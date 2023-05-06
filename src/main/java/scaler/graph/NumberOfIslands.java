package scaler.graph;

import java.util.*;

/**
 * Given a matrix of integers A of size N x M consisting of 0 and 1. A group of connected 1's forms an island.
 * From a cell (i, j) such that A[i][j] = 1 you can visit any cell that shares a corner with (i, j) and value in that cell is 1.
 * <p>
 * Return the number of islands.
 * <p>
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 */
public class NumberOfIslands {
    public static void main(String[] args) {
        int[][] A = new int[][]{{0, 1, 1}, {0, 0, 1}, {1, 0, 0}};
        System.out.println(solve(A));

        A = new int[][]{
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        System.out.println(solve(A));
    }

    /* Approach is to consider the (i, j) pair as the vertex. In that way we can use either BFS or DFS to traverse
     * the graph for each cell where value is 1. For marking visited cells, we can either take a Hashmap<String, Boolean>
     * or a 2D matrix
     */
    private static int solve(int[][] A) {
        int noOfIslands = 0;
        final Queue<Map.Entry<Integer, Integer>> queue = new LinkedList<>();
        final boolean[][] visited = new boolean[A.length][A[0].length];

        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {

                if (A[i][j] != 0 && !visited[i][j]) {
                    noOfIslands++;
                    visited[i][j] = true;
                    queue.add(new AbstractMap.SimpleEntry<>(i, j));

                    while (!queue.isEmpty()) {

                        final Map.Entry<Integer, Integer> entry = queue.poll();
                        int a = entry.getKey();
                        int b = entry.getValue();

                        //Top
                        if (a - 1 >= 0 && A[a - 1][b] != 0 && !visited[a - 1][b]) {
                            queue.add(new AbstractMap.SimpleEntry<>(a - 1, b));
                            visited[a - 1][b] = true;
                        }

                        //Top left
                        if (a - 1 >= 0 && b - 1 >= 0 && A[a - 1][b - 1] != 0 && !visited[a - 1][b - 1]) {
                            queue.add(new AbstractMap.SimpleEntry<>(a - 1, b - 1));
                            visited[a - 1][b - 1] = true;
                        }

                        //Left
                        if (b - 1 >= 0 && A[a][b - 1] != 0 && !visited[a][b - 1]) {
                            queue.add(new AbstractMap.SimpleEntry<>(a, b - 1));
                            visited[a][b - 1] = true;
                        }

                        //Bottom left
                        if (a + 1 < A.length && b - 1 >= 0 && A[a + 1][b - 1] != 0 && !visited[a + 1][b - 1]) {
                            queue.add(new AbstractMap.SimpleEntry<>(a + 1, b - 1));
                            visited[a + 1][b - 1] = true;
                        }

                        //Bottom
                        if (a + 1 < A.length && A[a + 1][b] != 0 && !visited[a + 1][b]) {
                            queue.add(new AbstractMap.SimpleEntry<>(a + 1, b));
                            visited[a + 1][b] = true;
                        }

                        //Bottom right
                        if (a + 1 < A.length && b + 1 < A[0].length && A[a + 1][b + 1] != 0 && !visited[a + 1][b + 1]) {
                            queue.add(new AbstractMap.SimpleEntry<>(a + 1, b + 1));
                            visited[a + 1][b + 1] = true;
                        }

                        //Right
                        if (b + 1 < A[0].length && A[a][b + 1] != 0 && !visited[a][b + 1]) {
                            queue.add(new AbstractMap.SimpleEntry<>(a, b + 1));
                            visited[a][b + 1] = true;
                        }

                        //Top right
                        if (a - 1 >= 0 && b + 1 < A[0].length && A[a - 1][b + 1] != 0 && !visited[a - 1][b + 1]) {
                            queue.add(new AbstractMap.SimpleEntry<>(a - 1, b + 1));
                            visited[a - 1][b + 1] = true;
                        }
                    }
                }
            }
        }

        return noOfIslands;
    }
}
