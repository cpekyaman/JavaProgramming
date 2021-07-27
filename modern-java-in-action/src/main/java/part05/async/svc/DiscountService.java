package part05.async.svc;

import part05.async.domain.Price;
import part05.async.domain.PriceQuote;
import part05.async.svc.impl.DiscountServiceSimulator;

public interface DiscountService {
    static DiscountService instance() {
        return new DiscountServiceSimulator();
    }

    Price calculateDiscount(PriceQuote quote);
}
