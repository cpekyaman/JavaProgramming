package part06.functional;

import java.util.function.Predicate;

public interface MyList<T> {
    T head();

    MyList<T> tail();

    default boolean isEmpty() {
        return true;
    }

    MyList<T> filter(Predicate<T> predicate);
}
