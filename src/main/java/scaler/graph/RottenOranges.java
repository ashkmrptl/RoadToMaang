package scaler.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix of integers A of size N x M consisting of 0, 1 or 2.
 * <p>
 * Each cell can have three values:
 * The value 0 representing an empty cell.
 * The value 1 representing a fresh orange.
 * The value 2 representing a rotten orange.
 * <p>
 * Every minute, any fresh orange that is adjacent (Left, Right, Top, or Bottom) to a rotten orange becomes rotten.
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1 instead.
 * Note: Your solution will run on multiple test cases. If you are using global variables, make sure to clear them.
 */
public class RottenOranges {
    public static void main(String[] args) {
        int[][] A = new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}};
        System.out.println(solve(A));

        A = new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}};
        System.out.println(solve(A));
    }

    //Approach is to use BFS
    private static int solve(int[][] A) {
        int[][] minutes = new int[A.length][A[0].length];

        final Queue<Pair> queue = new LinkedList<>();

        //Adding all rotten oranges in the matrix
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        if (queue.isEmpty()) {//No rotten oranges
            return -1;
        }

        int result = Integer.MIN_VALUE;

        //Perform BFS
        while (!queue.isEmpty()) {
            final Pair pair = queue.poll();

            //TOP
            if (pair.x - 1 >= 0 && A[pair.x - 1][pair.y] == 1) {
                queue.add(new Pair(pair.x - 1, pair.y));
                int time = minutes[pair.x][pair.y] + 1;
                result = Math.max(time, result);
                minutes[pair.x - 1][pair.y] = time;
                A[pair.x - 1][pair.y] = -1;
            }

            //LEFT
            if (pair.y - 1 >= 0 && A[pair.x][pair.y - 1] == 1) {
                queue.add(new Pair(pair.x, pair.y - 1));
                int time = minutes[pair.x][pair.y] + 1;
                result = Math.max(time, result);
                minutes[pair.x][pair.y - 1] = time;
                A[pair.x][pair.y - 1] = -1;
            }

            //BOTTOM
            if (pair.x + 1 < A.length && A[pair.x + 1][pair.y] == 1) {
                queue.add(new Pair(pair.x + 1, pair.y));
                int time = minutes[pair.x][pair.y] + 1;
                result = Math.max(time, result);
                minutes[pair.x + 1][pair.y] = time;
                A[pair.x + 1][pair.y] = -1;
            }

            //RIGHT
            if (pair.y + 1 < A[0].length && A[pair.x][pair.y + 1] == 1) {
                queue.add(new Pair(pair.x, pair.y + 1));
                int time = minutes[pair.x][pair.y] + 1;
                result = Math.max(time, result);
                minutes[pair.x][pair.y + 1] = time;
                A[pair.x][pair.y + 1] = -1;
            }
        }

        //Check for unvisited nodes/vertices
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    return -1;
                }
            }
        }

        return result;
    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "(" + x + ", " + y + ")";
        }
    }
}
