package part05.async.svc;

import part05.async.domain.PriceQuote;
import part05.async.svc.impl.ShopServiceSimulator;

public interface ShopService {
    static ShopService byName(String shopName) {
        return new ShopServiceSimulator(shopName);
    }

    String getName();

    PriceQuote calculatePrice(String productName);
}
