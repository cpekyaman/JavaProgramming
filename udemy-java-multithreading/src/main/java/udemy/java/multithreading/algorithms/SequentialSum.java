package udemy.java.multithreading.algorithms;

public class SequentialSum {
    private final int[] numbers;
    private long sum = 0;

    public SequentialSum(int[] numbers) {
        this.numbers = numbers;
    }

    public long calculate() {
        for(int i = 0; i<numbers.length;++i) {
            sum += numbers[i];
        }
        return sum;
    }
}
