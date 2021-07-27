package part05.async.svc.impl;

import part05.async.domain.Price;
import part05.async.domain.PriceQuote;
import part05.async.svc.DiscountService;

public final class DiscountServiceSimulator extends ServiceSimulator implements DiscountService {
    @Override
    public Price calculateDiscount(PriceQuote quote) {
        delay();
        return new Price(quote.getPrice().getShopName(), quote.getPrice().getAmount().applyRate(quote.getDiscountCode().getPercentage()));
    }
}
