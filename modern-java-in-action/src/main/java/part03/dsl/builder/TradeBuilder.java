package part03.dsl.builder;

import part03.dsl.domain.Stock;
import part03.dsl.domain.Trade;
import part03.dsl.domain.TradeType;

import java.util.function.Consumer;

public final class TradeBuilder {
    private final TradeType type;
    private Stock stock;
    private int quantity;
    private double price;

    private TradeBuilder(TradeType type) {
        this.type = type;
    }

    public static TradeBuilder as(TradeType type) {
        return new TradeBuilder(type);
    }

    public TradeBuilder with(int quantity) {
        this.quantity = quantity;
        return this;
    }

    public TradeBuilder at(double price) {
        this.price = price;
        return this;
    }

    public TradeBuilder of(Consumer<StockBuilder> stock) {
        StockBuilder stockBuilder = new StockBuilder();
        stock.accept(stockBuilder);
        this.stock = stockBuilder.build();
        return this;
    }

    public Trade build() {
        return new Trade(type, stock, quantity, price);
    }
}
