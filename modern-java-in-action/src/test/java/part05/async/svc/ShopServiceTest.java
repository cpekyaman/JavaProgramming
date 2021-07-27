package part05.async.svc;

import org.junit.Before;
import org.junit.Test;
import part05.async.domain.Currency;
import part05.async.domain.Price;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ShopServiceTest {

    private DiscountService discountService;
    private ExchangeRateService exchangeRateService;

    private String productName;
    private List<ShopService> shops;

    @Before
    public void setUp() {
        discountService = DiscountService.instance();
        exchangeRateService = ExchangeRateService.instance();

        productName = "Garbage";

        shops = List.of(
                ShopService.byName("BestPrice"),
                ShopService.byName("BigSaves"),
                ShopService.byName("Favorite"),
                ShopService.byName("BuyAll"));
    }

    @Test
    public void testFindPricesStream() {
        // given
        long start = System.nanoTime();

        // when
        shops.stream()
                .map(shop -> shop.calculatePrice(productName))
                .map(quote -> discountService.calculateDiscount(quote))
                .map(price -> price.applyRate(exchangeRateService.getRate(Currency.EUR, Currency.USD)))
                .forEach(System.out::println);

        // then
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("duration with streams is " + duration);
    }

    @Test
    public void testFindPricesFuture() {
        // given
        long start = System.nanoTime();

        // when
        List<CompletableFuture<Void>> futures = shops.stream()
                // get the price quote from shop
                .map(shop -> async(() -> shop.calculatePrice(productName)))
                // then get the discounted price for quote
                .map(quoteFuture -> quoteFuture.thenCompose(quote -> async(() -> discountService.calculateDiscount(quote))))
                // then convert eur rate to usd for price
                .map(priceFuture -> priceFuture.thenCombine(
                        async(() -> exchangeRateService.getRate(Currency.EUR, Currency.USD))
                                .completeOnTimeout(1.0D,2, TimeUnit.SECONDS),
                        Price::applyRate))
                // then print the string representation of it
                .map(priceFuture -> priceFuture.thenAccept(System.out::println))
                .collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();

        // then
        long duration = (System.nanoTime() - start) / 1_000_000;
        System.out.println("duration with futures is " + duration);
    }

    private <OUT> CompletableFuture<OUT> async(Supplier<OUT> supplier) {
        return CompletableFuture.supplyAsync(supplier);
    }
}