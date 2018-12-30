package udemy.java.algorithmic.recursion.factorial;

final class Factorial {
    private final int number;

    Factorial(int number) {
        this.number = number;
    }

    int calculate() {
        return factorialN(number, 1);
    }

    private int factorialN(int n, int accumulator) {
        if(n <= 1) {
            return accumulator;
        }
        return factorialN(n - 1, accumulator * n);
    }

    public static void main(String[] args) {
        System.out.println(new Factorial(5).calculate());
        System.out.println(new Factorial(6).calculate());
    }
}
