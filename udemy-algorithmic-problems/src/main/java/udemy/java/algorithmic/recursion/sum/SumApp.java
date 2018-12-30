package udemy.java.algorithmic.recursion.sum;

public class SumApp {
    public static void main(String[] args) {
        System.out.println(new IterativeSum(5).sum());
        System.out.println(new RecursiveSum(5).sum());
    }
}
