package part05.async.svc;

import part05.async.domain.Currency;
import part05.async.svc.impl.ExchangeRateServiceSimulator;

public interface ExchangeRateService {
    static ExchangeRateService instance() {
        return new ExchangeRateServiceSimulator();
    }

    double getRate(Currency from, Currency to);
}
