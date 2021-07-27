package part05.async.domain;

public final class Price {
    private final String shopName;
    private Money amount;

    public Price(String shopName, Currency currency, double amount) {
        this(shopName, new Money(currency, amount));
    }

    public Price(String shopName, Money amount) {
        this.shopName = shopName;
        this.amount = amount;
    }

    public String getShopName() {
        return shopName;
    }

    public Money getAmount() {
        return amount;
    }

    public Price applyRate(double rate) {
        this.amount = new Money(this.amount.getCurrency(), this.amount.getValue() * rate);
        return this;
    }

    @Override
    public String toString() {
        return String.format("%s:%s", shopName, amount);
    }
}
