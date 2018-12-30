package udemy.java.algorithmic.recursion.gcd;

public class GcdFinder {
    private final int first;
    private final int second;

    public GcdFinder(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int find() {
        return findN(first, second);
    }

    private int findN(int n1, int n2) {
        if(n2 == 0) {
            return n1;
        }

        return findN(n2, n1 % n2);
    }
}
