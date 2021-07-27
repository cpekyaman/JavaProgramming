package udemy.java.algorithmic.backtracking;

public class Coloring {
    private int numberOfVertices;
    private int[] colors;

    private final int numberOfColors;
    private final int[][] adjacencyMatrix;

    public Coloring(int[][] adjacencyMatrix, int numberOfColors) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.numberOfColors = numberOfColors;
        this.numberOfVertices = adjacencyMatrix.length;
        this.colors = new int[adjacencyMatrix.length];
    }

    public void solve() {
        if(solve(0)) {
            showResult();
        } else {
            System.out.println("no solution");
        }
    }

    private boolean solve(int nodeIndex) {
        if(nodeIndex == numberOfVertices) {
            return true;
        }

        for(int colorIndex=1; colorIndex <= numberOfColors; ++colorIndex) {
            if(isColorValid(nodeIndex, colorIndex)) {
                colors[nodeIndex] = colorIndex;
                if(solve(nodeIndex + 1)) {
                    return true;
                }
            }
            // backtracking
        }

        return false;
    }

    private boolean isColorValid(int nodeIndex, int colorIndex) {
        for(int n = 0; n < numberOfVertices; ++n) {
            if(adjacencyMatrix[nodeIndex][n] == 1 && colorIndex == colors[n]) {
                return false;
            }
        }
        return true;
    }

    private void showResult() {
        //TODO: print colors array (ith element is color of i vertex)
    }
}
