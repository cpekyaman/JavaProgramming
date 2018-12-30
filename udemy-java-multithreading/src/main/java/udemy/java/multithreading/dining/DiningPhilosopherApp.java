package udemy.java.multithreading.dining;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiningPhilosopherApp {
    public static void main(String[] args) throws InterruptedException {
        List<Chopstick> chopsticks = IntStream
                .rangeClosed(1, DiningPhilosopherConstants.NUMBER_OF_CHOPSTICKS)
                .boxed()
                .map(Chopstick::new)
                .collect(Collectors.toList());

        List<Philosopher> philosophers = IntStream
                .rangeClosed(1, DiningPhilosopherConstants.NUMBER_OF_PHILOSOPHERS)
                .boxed()
                .map(i -> new Philosopher(i, chopsticks.get(i - 1), chopsticks.get(i % chopsticks.size())))
                .collect(Collectors.toList());

        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(DiningPhilosopherConstants.NUMBER_OF_PHILOSOPHERS);
            philosophers.forEach(executorService::execute);

            Thread.sleep(DiningPhilosopherConstants.SIMULATION_DURATION);
            philosophers.forEach(Philosopher::done);
        } finally {
            if(executorService != null) {
                executorService.shutdown();
            }
        }
    }
}
