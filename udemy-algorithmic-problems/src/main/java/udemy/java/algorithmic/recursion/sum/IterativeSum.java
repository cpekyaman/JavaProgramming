package udemy.java.algorithmic.recursion.sum;

final class IterativeSum {
    private final int sumTo;

    IterativeSum(int sumTo) {
        this.sumTo = sumTo;
    }

    int sum() {
        int result = 0;
        for(int i = 1; i <= sumTo; ++i) {
            result += i;
        }
        return result;
    }
}
