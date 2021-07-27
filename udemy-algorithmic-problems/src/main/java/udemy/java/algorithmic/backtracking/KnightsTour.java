package udemy.java.algorithmic.backtracking;

public class KnightsTour {
    private final int[][] board;
    private final Move[] moves;

    public KnightsTour(int boardSize) {
        this.board = new int[boardSize][boardSize];
        this.moves= new Move[]{
                new Move(2,1),
                new Move(1,2),
                new Move(-1,2),
                new Move(-2,1),
                new Move(-2,-1),
                new Move(-1,-2),
                new Move(1,-2),
                new Move(2,-1)
        };
    }

    public void solve(){
        board[0][0] = 1;

        if(solve(2, 0, 0)) {
            printSolution();
        } else {
            System.out.println("no solution");
        }
    }

    private void printSolution() {
        System.out.println("Solution:");
        //TODO: print array
    }

    private boolean solve(int step, int x, int y) {
        if(step == board.length * board.length + 1) {
            return true;
        }

        for(int i = 0; i < moves.length; ++i) {
            int nextX = x + moves[i].x;
            int nextY = y + moves[i].y;

            if(isValidStep(nextX, nextY)) {
                board[nextX][nextY] = step;
                if(solve(step + 1, nextX, nextY)) {
                    return true;
                }
                board[nextX][nextY] = 0;
            }
        }

        return false;
    }

    private boolean isValidStep(int x, int y) {
        if(x > 0 && x < board.length && y > 0 && y < board.length) {
            return board[x][y] == 0;
        }
        return false;
    }

    static final class Move {
        private final int x;
        private final int y;

        Move(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
