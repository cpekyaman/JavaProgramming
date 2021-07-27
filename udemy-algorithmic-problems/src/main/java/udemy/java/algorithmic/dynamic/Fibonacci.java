package udemy.java.algorithmic.dynamic;

import java.util.HashMap;
import java.util.Map;

final class Fibonacci {
    private final Map<Integer, Integer> memoize;

    Fibonacci() {
        this.memoize = new HashMap<>();
        this.memoize.put(0, 0);
        this.memoize.put(1,1);
    }

    int calculateDP(int n) {
        if(memoize.containsKey(n)) {
            return memoize.get(n);
        }

        memoize.put(n - 1, calculateDP(n - 1));
        memoize.put(n - 2, calculateDP(n - 2));

        memoize.put(n, memoize.get(n - 1) + memoize.get(n - 2));
        return memoize.get(n);
    }

    int calculateRecursive(int n) {
        if(n <= 1) {
            return n;
        }

        return calculateRecursive(n - 1) + calculateRecursive(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(new Fibonacci().calculateDP(6));
    }
}
