package part03.dsl.builder;

import part03.dsl.domain.Customer;
import part03.dsl.domain.Order;
import part03.dsl.domain.Trade;
import part03.dsl.domain.TradeType;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class OrderBuilder {
    private String customerName;
    private final List<Trade> trades = new ArrayList<>();

    public static Order order(Consumer<OrderBuilder> consumer) {
        OrderBuilder builder = new OrderBuilder();
        consumer.accept(builder);
        return builder.build();
    }

    public OrderBuilder by(String customerName) {
        this.customerName = customerName;
        return this;
    }

    public OrderBuilder buy(Consumer<TradeBuilder> consumer) {
        return trade(TradeType.BUY, consumer);
    }

    public OrderBuilder sell(Consumer<TradeBuilder> consumer) {
        return trade(TradeType.SELL, consumer);
    }

    private OrderBuilder trade(TradeType type, Consumer<TradeBuilder> consumer) {
        TradeBuilder builder = TradeBuilder.as(type);
        consumer.accept(builder);
        trades.add(builder.build());
        return this;
    }

    private Order build() {
        return new Order(new Customer(customerName), trades);
    }
}
