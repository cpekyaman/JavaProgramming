package part05.async.svc.impl;

import java.util.Random;

abstract class ServiceSimulator {
    protected final Random random;

    public ServiceSimulator() {
        random = new Random();
    }

    void delay() {
        try {
            Thread.sleep(500 + random.nextInt(500));
        } catch (InterruptedException e) {
            throw new RuntimeException("Could not sleep", e);
        }
    }
}
