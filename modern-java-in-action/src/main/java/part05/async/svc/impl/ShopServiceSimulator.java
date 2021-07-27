package part05.async.svc.impl;

import part05.async.domain.Currency;
import part05.async.domain.DiscountCode;
import part05.async.domain.Price;
import part05.async.domain.PriceQuote;
import part05.async.svc.ShopService;

public final class ShopServiceSimulator extends ServiceSimulator implements ShopService {
    private final String shopName;

    public ShopServiceSimulator(String shopName) {
        this.shopName = shopName;
    }

    @Override
    public String getName() {
        return shopName;
    }

    @Override
    public PriceQuote calculatePrice(String productName) {
        delay();
        DiscountCode discountCode = DiscountCode.values()[random.nextInt(DiscountCode.values().length)];
        double price = random.nextDouble() * productName.charAt(0) + productName.charAt(1);
        return new PriceQuote(new Price(this.shopName, Currency.EUR, price), discountCode);
    }
}
