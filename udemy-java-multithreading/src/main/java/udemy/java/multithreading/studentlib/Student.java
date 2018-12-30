package udemy.java.multithreading.studentlib;

import java.util.List;
import java.util.Random;

public class Student implements Runnable {
    private final int id;
    private final List<Book> books;
    private final Random random;
    private volatile boolean done = false;

    public Student(int id, List<Book> books) {
        this.id = id;
        this.books = books;
        this.random = new Random();
    }

    public String toString() {
        return Integer.toString(id);
    }

    public void done() {
        this.done = true;
    }

    @Override
    public void run() {
        while(! done) {
            Book book = books.get(random.nextInt(books.size()));
            try {
                if(book.tryRead()) {
                    System.out.println(String.format("Student %d is reading book %s", id, book));
                    Thread.sleep(25 + random.nextInt(25));
                    System.out.println(String.format("Student %d finished reading book %s", id, book));
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                book.finishReading();
            }
        }
    }
}
