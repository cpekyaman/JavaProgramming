package part02.parallelprocessing;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;

public class ForkJoinLongSumTest  {
    private ForkJoinPool pool;

    @Before
    public void setUp() {
        pool = new ForkJoinPool();
    }

    @After
    public void tearDown() throws InterruptedException {
        pool.awaitTermination(1, TimeUnit.SECONDS);
    }

    @Test
    public void testSum() {
        long[] numbers = LongStream.rangeClosed(1, 100_000).toArray();
        ForkJoinTask<Long> task = new ForkJoinLongSum(numbers, 0, numbers.length);
        System.out.println(pool.invoke(task));
    }
}