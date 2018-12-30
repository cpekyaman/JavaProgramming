package udemy.java.multithreading.forkjoin.findmax;

import java.util.concurrent.RecursiveTask;

public class ParallelFindMax extends RecursiveTask<Integer> {
    private final int[] numbers;
    private final int low;
    private final int high;
    private final int sequentialThreshold;

    public ParallelFindMax(int[] numbers, int low, int high, int sequentialThreshold) {
        this.numbers = numbers;
        this.low = low;
        this.high = high;
        this.sequentialThreshold = sequentialThreshold;
    }

    @Override
    protected Integer compute() {
        if(high - low < sequentialThreshold) {
            return new SequentialFindMax(numbers, low, high).find();
        } else {
            int middle = (low + high) / 2;

            ParallelFindMax firstHalf = new ParallelFindMax(numbers, low, middle, sequentialThreshold);
            ParallelFindMax secondHalf = new ParallelFindMax(numbers, middle + 1, high, sequentialThreshold);

            invokeAll(firstHalf, secondHalf);

            return Math.max(firstHalf.join(), secondHalf.join());
        }
    }
}
