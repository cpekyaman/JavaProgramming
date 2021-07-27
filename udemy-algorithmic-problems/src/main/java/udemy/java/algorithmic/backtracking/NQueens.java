package udemy.java.algorithmic.backtracking;

public class NQueens {
    private final int[][] board;
    private final int queens;

    public NQueens(int queens) {
        this.queens = queens;
        this.board = new int[queens][queens];
    }

    public void solve() {
        if(placeQueens(0)) {
            printSolution();
        } else {
            System.out.println("No Solution");
        }
    }

    private boolean placeQueens(int column) {
        if(column == queens) {
            return true;
        }

        for(int row = 0; row < queens; ++row) {
            if(isValidPlacement(row, column)) {
                board[row][column] = 1;
                if(placeQueens(column + 1)) {
                    return true;
                }
                board[row][column] = 0;
            }
        }

        return false;
    }

    private boolean isValidPlacement(int row, int column) {
        for(int i = 0; i < column; ++i) {
            if(board[row][i] == 1) {
                return false;
            }
        }

        //TODO: check diagonals

        return true;
    }

    private void printSolution() {
        for(int row = 0; row < board.length; ++row) {
            for(int column = 0; column < board[row].length; ++column) {
                if(board[row][column] == 1) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" - ");
                }
            }
            System.out.println();
        }
    }
}
