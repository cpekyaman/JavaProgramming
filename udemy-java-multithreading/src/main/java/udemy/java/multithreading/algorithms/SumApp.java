package udemy.java.multithreading.algorithms;

import java.util.Random;

public class SumApp {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        int[] numbers = new int[100000000];
        for(int i = 0; i < numbers.length; ++i) {
            numbers[i] = random.nextInt(100);
        }

        long sequentialStart = System.currentTimeMillis();
        System.out.println(new SequentialSum(numbers).calculate());
        long sequentialEnd = System.currentTimeMillis();
        System.out.println("Sequential finished in " + (sequentialEnd - sequentialStart) + " ms");

        long parallelStart = System.currentTimeMillis();
        System.out.println(new ParallelSum(numbers, Runtime.getRuntime().availableProcessors()).calculate());
        long parallelEnd = System.currentTimeMillis();
        System.out.println("Parallel finished in " + (parallelEnd - parallelStart) + " ms");
    }
}
