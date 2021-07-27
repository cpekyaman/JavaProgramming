package part02.parallelprocessing;

import java.util.concurrent.RecursiveTask;

public class ForkJoinLongSum extends RecursiveTask<Long> {
    private static final int THRESHOLD = 100;

    private final long[] numbers;
    private final int start;
    private final int end;

    public ForkJoinLongSum(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        int length = end - start;
        if(length < THRESHOLD) {
            return computeSequentially();
        } else {
            return divideAndCompute(length);
        }
    }

    private Long divideAndCompute(int length) {
        ForkJoinLongSum left = new ForkJoinLongSum(numbers, start, start + length / 2);
        left.fork();

        ForkJoinLongSum right = new ForkJoinLongSum(numbers, start + length / 2, end);
        // calling compute on one side is better than calling fork on both sides
        // right.fork();
        // Long rightSum = right.join();
        Long rightSum = right.compute();

        Long leftSum = left.join();
        return rightSum + leftSum;
    }

    private Long computeSequentially() {
        long sum = 0;
        for(int i=start; i < end; i++) {
            sum += numbers[i];
        }
        return sum;
    }
}
