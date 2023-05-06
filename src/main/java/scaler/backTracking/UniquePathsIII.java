package scaler.backTracking;

public class UniquePathsIII {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}};
        System.out.println(solve(A));
    }

    /**
     * There are is one optimization can be made here. Instead of taking a visited array we can modify the same array
     * to mark visited nodes. Update the visited cells with -1 and in canMove() check the bounds as well as the cell value is not -1.
     * <p>
     * Also, we can take two array for possible next movements.
     * int[] xPoints = {0, -1, 0, 1}
     * int[] yPoints = {-1, 0, 1, 0}
     */

    private static int solve(int[][] A) {
        //Create the visited array and find the path length(no of non-obstacle cells). Also find the starting index (x, y)
        int x = 0;
        int y = 0;
        int length = 0;
        int[][] visited = new int[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] != -1) {
                    length++;
                    visited[i][j] = 0;
                    if (A[i][j] == 1) {
                        x = i;
                        y = j;
                    }
                } else {
                    visited[i][j] = 1;
                }
            }
        }

        countPaths(x, y, length, 0, visited, A);

        return count;
    }

    private static int count = 0;

    private static void countPaths(int i, int j, int length, int currLength, int[][] visited, int[][] A) {
        //Base case 1: When destination is reached
        if (A[i][j] == 2) {
            currLength++;
            if (currLength == length) {
                count++;
            }
            return;
        }

        //Base case 2: When there is no cell to move further
        if (!canMove(i, j - 1, visited) && !canMove(i - 1, j, visited) && !canMove(i, j + 1, visited) && !canMove(i + 1, j, visited)) {
            return;
        }

        if (canMove(i, j - 1, visited)) {//left
            //Mark current cell as visited and move left
            visited[i][j] = 1;
            countPaths(i, j - 1, length, currLength + 1, visited, A);
            visited[i][j] = 0;
        }

        if (canMove(i, j + 1, visited)) {//right
            //Mark current cell as visited and move left
            visited[i][j] = 1;
            countPaths(i, j + 1, length, currLength + 1, visited, A);
            visited[i][j] = 0;
        }

        if (canMove(i - 1, j, visited)) {//top
            //Mark current cell as visited and move left
            visited[i][j] = 1;
            countPaths(i - 1, j, length, currLength + 1, visited, A);
            visited[i][j] = 0;
        }

        if (canMove(i + 1, j, visited)) {//bottom
            //Mark current cell as visited and move left
            visited[i][j] = 1;
            countPaths(i + 1, j, length, currLength + 1, visited, A);
            visited[i][j] = 0;
        }

    }

    private static boolean canMove(int i, int j, int[][] visited) {
        if ((i >= 0 && i < visited.length) && (j >= 0 && j < visited[0].length) && visited[i][j] != 1) {
            return true;
        } else {
            return false;
        }
    }
}
