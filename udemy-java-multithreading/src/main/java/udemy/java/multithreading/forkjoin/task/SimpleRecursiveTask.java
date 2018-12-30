package udemy.java.multithreading.forkjoin.task;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer> {
    private final int workLoad;

    public SimpleRecursiveTask(int workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected Integer compute() {
        if(workLoad > 20) {
            System.out.println("splitting workload " + workLoad);
            ForkJoinTask<Integer> firstHalf = new SimpleRecursiveTask(workLoad / 2).fork();
            ForkJoinTask<Integer> secondHalf = new SimpleRecursiveTask(workLoad / 2).fork();

            Integer firstResult = firstHalf.fork().join();
            Integer secondResult = secondHalf.fork().join();
            System.out.println("returning splitted sum " + (firstResult + secondResult));
            return firstResult + secondResult;
        } else {
            System.out.println("returning " + workLoad);
            return workLoad;
        }
    }
}
