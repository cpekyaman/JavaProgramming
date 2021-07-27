package udemy.java.algorithmic.backtracking;

public class HamiltonianCycle {
    private int numberOfVertices;
    private int[] path;
    private final int[][] adjacencyMatrix;

    public HamiltonianCycle(int[][] adjacencyMatrix) {
        this.adjacencyMatrix = adjacencyMatrix;
        this.path = new int[adjacencyMatrix.length];
        this.numberOfVertices = adjacencyMatrix.length;

        this.path[0] = 0;
    }

    public void solve() {
        if(! solve(1)) {
            System.out.println("No Solution");
        } else {
            printPath();
        }
    }

    private boolean solve(int pathPosition) {
        // end of the path
        // if last path element is neighbor to first
        // we have cycle
        if(pathPosition == numberOfVertices) {
            return adjacencyMatrix[path[pathPosition - 1]][path[0]] == 1;
        }

        // consider al vertices after initial (0 index)
        for(int vertex = 1; vertex < numberOfVertices; ++vertex) {
            if(isFeasible(vertex, pathPosition)) {
                // set for current position
                path[pathPosition] = vertex;

                // check for next position
                if(solve(pathPosition + 1)) {
                    return true;
                }

                // next iteration means backtrack
            }
        }

        return false;
    }

    private boolean isFeasible(int vertex, int pathPosition) {
        // neighbor to last path item
        if(adjacencyMatrix[path[pathPosition - 1]][vertex] == 0) {
            return false;
        }

        // not visited yet
        for(int i = 0; i < pathPosition; ++i) {
            if(path[i] == vertex) {
                return false;
            }
        }

        // vertex is valid for current iteration
        return true;
    }

    private void printPath() {
        //TODO: print path array
    }
}
