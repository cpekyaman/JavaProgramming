package udemy.java.multithreading.forkjoin.findmax;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class FindMaxApp {
    public static void main(String[] args) {
        Random random = new Random();

        int[] numbers = new int[100000];
        for(int i = 0; i < numbers.length; ++i) {
            numbers[i] = random.nextInt(100);
        }

        int parallelism = Runtime.getRuntime().availableProcessors();
        ForkJoinPool pool = new ForkJoinPool(parallelism);
        Integer max = pool.invoke(new ParallelFindMax(numbers, 0, numbers.length, numbers.length / parallelism));
        System.out.println(max);
    }
}
