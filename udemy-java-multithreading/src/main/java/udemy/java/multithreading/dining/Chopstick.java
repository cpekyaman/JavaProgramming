package udemy.java.multithreading.dining;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public final class Chopstick {
    private final int id;
    private final ReentrantLock lock;

    public Chopstick(int id) {
        this.id = id;
        this.lock = new ReentrantLock(true);
    }

    public boolean pickUp() {
        try {
            return lock.tryLock(100, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean putDown() {
        if(lock.isHeldByCurrentThread()) {
            lock.unlock();
            return true;
        }
        return false;
    }

    public String toString() {
        return Integer.toString(id);
    }
}
