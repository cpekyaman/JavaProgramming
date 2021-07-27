package part05.async.domain;

public final class Money {
    private final Currency currency;
    private final double value;

    public Money(Currency currency, double value) {
        this.currency = currency;
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public double getValue() {
        return value;
    }

    public Money applyRate(double rate) {
        return new Money(this.currency, this.value * (100 - rate) / 100);
    }

    @Override
    public String toString() {
        return String.format("Money(%.2f %s)", value, currency);
    }
}
