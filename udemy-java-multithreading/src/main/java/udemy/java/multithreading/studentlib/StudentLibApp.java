package udemy.java.multithreading.studentlib;

import udemy.java.multithreading.dining.DiningPhilosopherConstants;
import udemy.java.multithreading.dining.Philosopher;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StudentLibApp {
    public static void main(String[] args) throws InterruptedException {
        List<Book> books = IntStream
                .rangeClosed(1, StudentLibConstants.NUMBER_OF_BOOKS)
                .boxed()
                .map(Book::new)
                .collect(Collectors.toList());

        List<Student> philosophers = IntStream
                .rangeClosed(1, StudentLibConstants.NUMBER_OF_STUDENTS)
                .boxed()
                .map(i -> new Student(i, books))
                .collect(Collectors.toList());

        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(DiningPhilosopherConstants.NUMBER_OF_PHILOSOPHERS);
            philosophers.forEach(executorService::execute);

            Thread.sleep(StudentLibConstants.SIMULATION_DURATION);
            philosophers.forEach(Student::done);
        } finally {
            if(executorService != null) {
                executorService.shutdown();
            }
        }
    }
}
