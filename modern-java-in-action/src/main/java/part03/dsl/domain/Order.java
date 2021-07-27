package part03.dsl.domain;

import java.util.List;
import java.util.StringJoiner;

public final class Order {
    private final Customer customer;
    private final List<Trade> trades;

    public Order(Customer customer, List<Trade> trades) {
        this.customer = customer;
        this.trades = trades;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Trade> getTrades() {
        return trades;
    }

    public double getValue() {
        return trades.stream().mapToDouble(Trade::getValue).sum();
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("customer=" + customer)
                .add("trades=" + trades)
                .toString();
    }
}
