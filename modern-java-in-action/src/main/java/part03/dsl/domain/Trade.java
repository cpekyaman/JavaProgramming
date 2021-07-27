package part03.dsl.domain;

import java.util.StringJoiner;

public final class Trade {
    private final TradeType type;
    private final Stock stock;
    private final int quantity;
    private final double price;

    public Trade(TradeType type, Stock stock, int quantity, double price) {
        this.type = type;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
    }

    public TradeType getType() {
        return type;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getValue() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Trade.class.getSimpleName() + "[", "]")
                .add("type=" + type)
                .add("stock=" + stock)
                .add("quantity=" + quantity)
                .add("price=" + price)
                .toString();
    }
}
