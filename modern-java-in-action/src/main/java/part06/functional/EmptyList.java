package part06.functional;

import java.util.function.Predicate;

public final class EmptyList<T> implements MyList<T> {
    @Override
    public T head() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyList<T> tail() {
        throw new UnsupportedOperationException();
    }

    @Override
    public MyList<T> filter(Predicate<T> predicate) {
        return this;
    }
}
