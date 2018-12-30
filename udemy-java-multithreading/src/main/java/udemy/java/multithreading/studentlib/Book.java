package udemy.java.multithreading.studentlib;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
    private final int id;
    private final ReentrantLock lock;

    public Book(int id) {
        this.id = id;
        this.lock = new ReentrantLock(true);
    }

    public boolean tryRead() {
        try {
           return lock.tryLock(50, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void finishReading() {
        if(lock.isHeldByCurrentThread()) {
            lock.unlock();
        }
    }

    public String toString() {
        return Integer.toString(id);
    }
}
