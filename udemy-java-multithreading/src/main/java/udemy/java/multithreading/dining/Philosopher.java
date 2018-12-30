package udemy.java.multithreading.dining;

import java.util.Random;

public class Philosopher implements Runnable {
    private final int id;
    private final Chopstick left;
    private final Chopstick right;

    private final Random random;
    private volatile boolean done;
    private int eatingCounter;

    public Philosopher(int id, Chopstick left, Chopstick right) {
        this.id = id;
        this.left = left;
        this.right = right;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            while (!done) {
                doWhatYouMustDo();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(String.format("Philosopher %d has eaten %d times", id, eatingCounter));
        }
    }

    private void doWhatYouMustDo() throws InterruptedException {
        think();
        try {
            if (left.pickUp()) {
                try {
                    if(right.pickUp()) {
                        eat();
                    }
                } finally {
                    right.putDown();
                }
            }
        } finally {
            left.putDown();
        }
    }

    private void think() throws InterruptedException {
        System.out.println(String.format("Philosopher %d is thinking", id));
        Thread.sleep(50 + random.nextInt(50));
    }

    private void eat() throws InterruptedException {
        System.out.println(String.format("Philosopher %d is eating", id));
        eatingCounter++;
        Thread.sleep(50 + random.nextInt(50));
    }

    public void done() {
        this.done = true;
    }

    public String toString() {
        return Integer.toString(id);
    }
}
