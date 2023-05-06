package scaler.graph;

import java.util.Arrays;

/**
 * This algorithm is used to find the shortest path from source to destination with -ve weights.
 * Also by this algo we can find if a -ve cycle exists or not.
 *
 * print the weight of shortest path from 1 to A
 */
public class BellmanFordAlgorithm {
    public static void main(String[] args) {
        int A = 6;
        int[][] B = new int[][]{{1, 2, 11}, {1, 4, 10}, {2, 3, -6}, {3, 4, -8}, {4, 5, 2}, {5, 6, -3}};
        System.out.println(Arrays.toString(solve(A, B)));

        A = 6;
        B = new int[][] {{1, 2, 1}, {2, 3, 2}, {5, 2, 3}, {3, 4, -3}, {4, 5, -4}, {4, 6, 5}};
        System.out.println(Arrays.toString(solve(A, B)));
    }

    private static int[] solve(int A, int[][] B) {
        //take the distance array and populate infinity for all vertices except the source
        final int[] distance = new int[A + 1];
        for (int i = 2; i < distance.length; i++) {//ignoring zero as nodes start from 1 ans as source is 1, not setting it infinity
            distance[i] = Integer.MAX_VALUE;
        }

        //There are 6 nodes, hence no of maximum edges in the shortest path is 6 - 1 = 5
        for (int i = 0; i < A; i++) {
            //traverse all edges
            for (int j = 0; j < B.length; j++) {
                int u = B[i][0];
                int v = B[i][1];
                int weight = B[i][2];

                final int dist = distance[u] + weight;
                if (dist < distance[v]) {
                    distance[v] = dist;
                }
            }
        }

        //One extra loop to check negative cycle
        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];

            int d = distance[u] + w;

            if (d < distance[v]) {//Negative cycle
                System.out.println("Graph has a -ve cycle");
            }
        }

        return distance;
    }
}
