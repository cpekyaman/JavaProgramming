package udemy.java.multithreading.forkjoin.task;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class SimpleRecursiveTaskApp {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        Integer result = pool.invoke(new SimpleRecursiveTask(1000));
        System.out.println(result);
    }
}
