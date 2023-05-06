package scaler.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Given a graph with A nodes and C weighted edges. Cost of constructing the graph is the sum of weights of all the edges in the graph.
 * Find the minimum cost of constructing the graph by selecting some given edges such that we can reach every other node from the 1st node.
 * NOTE: Return the answer modulo 109+7 as the answer can be large.
 */
public class ConstructionCost {
    public static void main(String[] args) {
        int A = 3;
        int[][] B = new int[][] {{1, 2, 14}, {2, 3, 7}, {3, 1, 2}};

        System.out.println(solve(A, B));
    }

    /**
     * Idea is to use Kruskal's algorithm for finding Minimum Spanning Tree(MST) using DSU(Disjoint set union) data structure
     */
    private static int solve(int A, int[][] B) {
        int mod = 1000 * 1000 * 1000 + 7;
        long totalCost = 0;

        //Sort the edges as per their weights
        final List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < B.length; i++) {
            edges.add(new Edge(B[i][0], B[i][1], B[i][2]));
        }

        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        int[] parent = new int[A + 1];

        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        //traverse each edges
        for (int i = 0; i < edges.size(); i++) {
            int x = edges.get(i).x;
            int y = edges.get(i).y;
            int weight = edges.get(i).weight;

            if (union(x, y, parent)) {
                totalCost = ((totalCost % mod) + (weight % mod)) % mod;
            }
        }

        return (int) (totalCost % mod);
    }

    private static boolean union(int v1, int v2, int[] parent) {
        int rootV1 = findRoot(v1, parent);
        int rootV2 = findRoot(v2, parent);

        if (rootV1 != rootV2) {
            parent[rootV1] = rootV2;

            return true;
        }

        return false;
    }

    private static int findRoot(int v, int[] parent) {
        while (v != parent[v]) {
            v = parent[v];
        }

        return v;
    }

    private static class Edge {
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }
}
