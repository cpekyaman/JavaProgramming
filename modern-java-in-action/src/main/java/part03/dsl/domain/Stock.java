package part03.dsl.domain;

import java.util.StringJoiner;

public final class Stock {
    private final String symbol;
    private final String market;

    public Stock(String symbol, String market) {
        this.symbol = symbol;
        this.market = market;
    }

    public String getSymbol() {
        return symbol;
    }

    public String getMarket() {
        return market;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Stock.class.getSimpleName() + "[", "]")
                .add("symbol='" + symbol + "'")
                .add("market='" + market + "'")
                .toString();
    }
}
