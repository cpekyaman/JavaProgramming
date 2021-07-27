package part06.functional;

import org.junit.Test;

public class LazyListTest {

    @Test
    public void testPrimeNumbers() {
        printTopN(primes(LazyList.from(2)), 20);
    }

    private MyList<Integer> primes(MyList<Integer> numbers) {
        return new LazyList<>(numbers.head(), () -> primes(numbers.tail().filter(n -> n % numbers.head() != 0)));
    }

    private void printTopN(MyList<Integer> numbers, int N) {
        if(! numbers.isEmpty() && N >= 0) {
            System.out.println(numbers.head());
            printTopN(numbers.tail(), N - 1);
        }
    }
}