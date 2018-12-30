package udemy.java.multithreading.forkjoin.findmax;

public class SequentialFindMax {
    private final int[] numbers;
    private final int low;
    private final int high;

    public SequentialFindMax(int[] numbers, int low, int high) {
        this.numbers = numbers;
        this.low = low;
        this.high = high;
    }

    public int find() {
        int max = numbers[low];
        for (int i = low + 1; i < high; ++i) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }

        return max;
    }
}
