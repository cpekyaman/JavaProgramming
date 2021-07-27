package part05.async.svc.impl;

import part05.async.domain.Currency;
import part05.async.svc.ExchangeRateService;

public final class ExchangeRateServiceSimulator extends ServiceSimulator implements ExchangeRateService {
    @Override
    public double getRate(Currency from, Currency to) {
        return 1.1D;
    }
}
