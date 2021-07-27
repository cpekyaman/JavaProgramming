package part06.functional;

import java.util.function.Predicate;
import java.util.function.Supplier;

public final class LazyList<T> implements MyList<T> {

    public static LazyList<Integer> from(int start) {
        return new LazyList<>(start, () -> from(start + 1));
    }

    private final T head;
    private final Supplier<MyList<T>> tail;

    public LazyList(T head, Supplier<MyList<T>> tail) {
        this.head = head;
        this.tail = tail;
    }

    @Override
    public T head() {
        return head;
    }

    @Override
    public MyList<T> tail() {
        return tail.get();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public MyList<T> filter(Predicate<T> predicate)  {
        if(isEmpty()) {
            return this;
        }

        return predicate.test(head())
                ? new LazyList<>(head, () -> tail().filter(predicate))
                : tail().filter(predicate);
    }
}
