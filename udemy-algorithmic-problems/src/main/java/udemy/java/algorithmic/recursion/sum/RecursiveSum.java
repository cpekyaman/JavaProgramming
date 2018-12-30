package udemy.java.algorithmic.recursion.sum;

final class RecursiveSum {
    private final int sumTo;

    RecursiveSum(int sumTo) {
        this.sumTo = sumTo;
    }

    int sum() {
        return sumN(sumTo, 0);
    }

    private int sumN(int n, int accumulator) {
        if(n == 0) {
            return accumulator;
        }
        return sumN(n - 1, n + accumulator);
    }
}
