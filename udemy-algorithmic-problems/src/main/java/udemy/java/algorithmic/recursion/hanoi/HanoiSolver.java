package udemy.java.algorithmic.recursion.hanoi;

public class HanoiSolver {
    public void solve(int n, char from, char middle, char to) {
        if(n == 1) {
            System.out.println("Plate 1 from rod " + from + " to rod " + to);
            return;
        }

        solve(n - 1, from, to, middle);
        System.out.println("Plate" + n + " from rod " + from + " to rod " + to);
        solve(n - 1, middle, from, to);
    }
}
