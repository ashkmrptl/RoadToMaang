package scaler.graph;

import java.util.Arrays;

/**
 * Given a matrix of integers A of size N x N, where A[i][j] represents the weight of directed edge from i to j (i ---> j).
 * If i == j, A[i][j] = 0, and if there is no directed edge from vertex i to vertex j, A[i][j] = -1.
 * Return a matrix B of size N x N where B[i][j] = shortest path from vertex i to vertex j.
 * If there is no possible path from vertex i to vertex j , B[i][j] = -1
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 */
public class FloydWarshallAlgorithm {
    public static void main(String[] args) {
        int[][] A = new int[][]{{0, 50, 39}, {-1, 0, 1}, {-1, 10, 0}};
        System.out.println(Arrays.deepToString(solve(A)));
    }

    private static int[][] solve(int[][] A) {
        int n = A.length;

        int[][] distance = new int[n][n];

        //Update already known distances
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] != -1) {
                    distance[i][j] = A[i][j];
                } else {
                    distance[i][j] = 1000000;//As per the constraint max val is less than 1000000, hence instead of MAX_VAL taken this to prevent overflow
                }
            }
        }

        //Consider all node as intermediate node
        for (int i = 0; i < n; i++) {
            for (int u = 0; u < n; u++) {
                for (int v = 0; v < n; v++) {
                    /*if (distance[u][i] == Integer.MAX_VALUE || distance[i][v] == Integer.MAX_VALUE) {
                        distance[u][v] = distance[u][v];
                    } else {
                        distance[u][v] = Math.min(distance[u][v], distance[u][i] + distance[i][v]);
                    }*/

                    distance[u][v] = Math.min(distance[u][v], distance[u][i] + distance[i][v]);
                }
            }
        }

        //Replace 1000000 with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (distance[i][j] == 1000000) {
                    distance[i][j] = -1;
                }
            }
        }

        return distance;
    }
}
