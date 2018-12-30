package udemy.java.multithreading.forkjoin.action;

import java.util.concurrent.RecursiveAction;

public class SimpleRecursiveAction extends RecursiveAction {
    private final int workLoad;

    public SimpleRecursiveAction(int workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {
        if(workLoad > 100) {
            System.out.println("workload is large, forking");
            new SimpleRecursiveAction(workLoad / 2).fork();
            new SimpleRecursiveAction(workLoad / 2).fork();
        } else {
            System.out.println("workload is ok, no forking");
        }
    }
}
