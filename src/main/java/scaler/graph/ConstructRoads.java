package scaler.graph;

import java.util.ArrayList;
import java.util.List;

public class ConstructRoads {
    public static void main(String[] args) {
        int A = 3;
        int[][] B = new int[][]{{1, 2}, {1, 3}};
        System.out.println(solve(A, B));

        A = 5;
        B = new int[][]{{1, 3}, {1, 4}, {3, 2}, {3, 5}};
        System.out.println(solve(A, B));
    }

    private static int result = 1;

    private static int solve(int A, int[][] B) {
        result = 1;
        int MOD = 1000 * 1000 * 1000 + 7;
        final List<List<Integer>> graph = createGraph(A, B);
        int[] colour = new int[A + 1];

        for (int i = 1; i < colour.length; i++) {
            if (colour[i] == 0) {
                colour[i] = -1;
                dfs(graph, colour, i);
            }
        }

        //color count
        long c1 = 0;
        long c2 = 0;
        for (int i = 1; i < colour.length; i++) {
            if (colour[i] == -1) {
                c1++;
            } else if (colour[i] == -2) {
                c2++;
            }
        }

        if (result == 0) {
            return 0;
        }

        return (int) (Math.max(0, (c1 * c2) - (A - 1)) % MOD);

    }

    private static List<List<Integer>> createGraph(int A, int[][] B) {
        final List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < A + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            int a = B[i][0];
            int b = B[i][1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        return graph;
    }

    private static void dfs(final List<List<Integer>> graph, int[] colour, int v) {
        final List<Integer> neighbours = graph.get(v);

        for (Integer neighbour : neighbours) {
            if (colour[v] == colour[neighbour]) {
                result = 0;
            }
            if (colour[neighbour] == 0) {
                colour[neighbour] = colour[v] == -1 ? -2 : -1;
                dfs(graph, colour, neighbour);
            }
        }
    }
}
