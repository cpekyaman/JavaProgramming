package udemy.java.algorithmic.backtracking;

public class Maze {
    private final int[][] maze;

    public Maze(int[][] maze) {
        this.maze = maze;
    }

    public void solve() {
        if(solve(0,0)) {
            printSolution();
        } else {
            System.out.println("No solution");
        }
    }

    private void printSolution() {
        //TODO: print maze array
    }

    private boolean solve(int x, int y) {
        if(isDone(x, y)) {
            return true;
        }

        if(isValid(x, y)) {
            maze[x][y] = 1;
            if(solve(x + 1, y) || solve(x, y + 1)) {
                return true;
            }
            maze[x][y] = 0;
        }

        return false;
    }

    private boolean isValid(int x, int y) {
        if(x > 0 && x < maze.length && y > 0 && y < maze.length) {
            return maze[x][y] >= 0;
        }
        return false;
    }

    private boolean isDone(int x, int y) {
        return x == maze.length - 1 && y == maze.length - 1;
    }
}
