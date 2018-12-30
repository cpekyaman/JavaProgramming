package udemy.java.multithreading.algorithms;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class SumWorker implements Runnable {
    private final int[] numbers;
    private final int low;
    private final int high;
    private final AtomicLong accumulator;
    private final CountDownLatch latch;

    public SumWorker(int[] numbers, int low, int high, AtomicLong accumulator, CountDownLatch latch) {
        this.numbers = numbers;
        this.low = low;
        this.high = high;
        this.accumulator = accumulator;
        this.latch = latch;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = low; i < high; ++i) {
            sum += numbers[i];
        }
        accumulator.addAndGet(sum);
        latch.countDown();
    }
}
