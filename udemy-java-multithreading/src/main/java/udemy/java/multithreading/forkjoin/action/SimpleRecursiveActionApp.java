package udemy.java.multithreading.forkjoin.action;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class SimpleRecursiveActionApp {
    public static void main(String[] args) throws InterruptedException {
        ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
        pool.invoke(new SimpleRecursiveAction(10000));
        pool.awaitTermination(10, TimeUnit.SECONDS);
    }
}
