package udemy.java.multithreading.algorithms;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class ParallelSum {
    private final int[] numbers;
    private final int threadCount;

    public ParallelSum(int[] numbers, int threadCount) {
        this.numbers = numbers;
        this.threadCount = threadCount;
    }

    public long calculate() throws InterruptedException {
        int partitionLength = (int) Math.ceil(numbers.length * 1.0 / threadCount);

        CountDownLatch latch = new CountDownLatch(threadCount);
        AtomicLong accumulator = new AtomicLong();

        IntStream.range(0, threadCount)
                .boxed()
                .map(i -> new Thread(workerForRange(latch, accumulator, i, partitionLength)))
                .forEach(Thread::start);

        latch.await();
        return accumulator.get();
    }

    private SumWorker workerForRange(CountDownLatch latch, AtomicLong accumulator, int index, int partitionLength) {
        return new SumWorker(numbers, index * partitionLength, Math.min((index + 1) * partitionLength, numbers.length), accumulator, latch);
    }
}
