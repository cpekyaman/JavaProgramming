package udemy.java.algorithmic.selection;

import java.util.Random;

public class QuickSelect {
    private final int[] numbers;

    public QuickSelect(int[] numbers) {
        this.numbers = numbers;
    }

    public int select(int k) {
        return select(0, numbers.length - 1, k - 1);
    }

    private int select(int first, int last, int k) {
        int pivot = partition(first, last);

        if(pivot > k) {
            return select(first, pivot - 1, k);
        } else if(pivot < k) {
            return select(pivot + 1, last, k);
        }

        return numbers[k];
    }

    private int partition(int first, int last) {
        int pivot = new Random().nextInt(last - first + 1) + first;
        swap(pivot, last);
        for(int i = first; i < last; ++i) {
            // if you change > to <, it will be kth smallest
            if(numbers[i] > numbers[last]) {
                swap(i, first);
                first++;
            }
        }

        swap(first, last);
        return first;
    }


    private void swap(int i, int j) {
        int temp = numbers[j];
        numbers[j] = numbers[i];
        numbers[i] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {1,-3,5,4,8,6,-2};
        System.out.println(new QuickSelect(numbers).select(3));
    }
}
