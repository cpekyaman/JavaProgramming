package part05.async.domain;

public final class PriceQuote {
    private final Price price;
    private final DiscountCode discountCode;

    public PriceQuote(Price price, DiscountCode discountCode) {
        this.price = price;
        this.discountCode = discountCode;
    }

    public Price getPrice() {
        return price;
    }

    public DiscountCode getDiscountCode() {
        return discountCode;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", price, discountCode);
    }
}
