package scaler.graph;

import java.util.*;

/**
 * Given a matrix of integers A of size N x M consisting of 0 or 1.
 *
 * For each cell of the matrix find the distance of nearest 1 in the matrix.
 *
 * Distance between two cells (x1, y1) and (x2, y2) is defined as |x1 - x2| + |y1 - y2|.
 *
 * Find and return a matrix B of size N x M which defines for each cell in A distance of nearest 1 in the matrix A.
 *
 * NOTE: There is at-least one 1 is present in the matrix.
 */
public class DistanceOfNearestCell {
    public static void main(String[] args) {
        int[][] A = new int[][] {{0, 0, 0, 1}, {0, 0, 1, 1}, {0, 1, 1, 0}};
        System.out.println(Arrays.deepToString(solve(A)));
    }

    //Approach is to do BFS starting from all ones and update the distance
    private static int[][] solve(int[][] A) {
        int[][] visited = new int[A.length][A[0].length];
        int[][] distance = new int[A.length][A[0].length];

        final Queue<Pair> queue = new LinkedList<>();

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        final List<Pair> directions = new ArrayList<>();
        directions.add(new Pair(-1, 0));
        directions.add(new Pair(0, 1));
        directions.add(new Pair(1, 0));
        directions.add(new Pair(0, -1));

        while (!queue.isEmpty()) {
            final Pair pair = queue.poll();

            //Check 4 direction
            for (int i = 0; i < directions.size(); i++) {
                final Pair direction = directions.get(i);

                int a = pair.a + direction.a;
                int b = pair.b + direction.b;

                if (a >= 0 && a < A.length && b >= 0 && b < A[0].length) {
                    if (A[a][b] == 0 && visited[a][b] == 0) {
                        distance[a][b] = distance[pair.a][pair.b] + 1;
                        visited[a][b] = 1;

                        queue.add(new Pair(a, b));
                    }
                }
            }
        }

        return distance;
    }

    private static class Pair {
        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "("+a+", "+b+")";
        }
    }
}
