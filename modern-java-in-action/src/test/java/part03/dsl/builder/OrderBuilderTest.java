package part03.dsl.builder;

import org.junit.Test;
import part03.dsl.domain.Order;

public class OrderBuilderTest {

    @Test
    public void testOrderBuilder() {
        Order order = OrderBuilder.order(o -> o.by("Cenk")
                        .buy(t -> t.at(10.0).with(10).of(s -> s.of("ABC").in("NY")))
                        .sell(t -> t.at(20.0).with(5).of(s -> s.of("DEF").in("LA")))
        );

        System.out.println(order);
    }
}