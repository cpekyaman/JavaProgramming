package part03.dsl.builder;

import part03.dsl.domain.Stock;

public final class StockBuilder {
    private String symbol;
    private String market;

    public StockBuilder of(String symbol) {
        this.symbol = symbol;
        return this;
    }

    public StockBuilder in(String market) {
        this.market = market;
        return this;
    }

    public Stock build() {
        return new Stock(symbol, market);
    }
}
