package scaler.graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * There are A islands and there are M bridges connecting them. Each bridge has some cost attached to it.
 * We need to find bridges with minimal cost such that all islands are connected.
 * It is guaranteed that input data will contain at least one possible scenario in which all islands are connected with each other.
 */
public class CommutableIslands {
    public static void main(String[] args) {
        int A = 4;
        int[][] B = new int[][] {{1, 2, 1}, {2, 3, 4}, {1, 4, 3}, {4, 3, 2}, {1, 3, 10}};
        System.out.println(solve(A, B));

        B = new int[][] {{1, 2, 1}, {2, 3, 2}, {3, 4, 4}, {1, 4, 3}};
        System.out.println(solve(A, B));
    }

    //Approach is to use Kruskal's algorithm to find MST
    private static int solve(int A, int[][] B) {
        //Create the list of edges
        final List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < B.length; i++) {
            edges.add(new Edge(B[i][0], B[i][1], B[i][2]));
        }

        //Sort the edges based on their costs
        edges.sort(Comparator.comparingInt(edge -> edge.cost));

        //Create the parent array and make each node/vertex as their parent
        final int[] parent = new int[A + 1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        int totalCost = 0;

        //Traverse all edges
        for (int i = 0; i < edges.size(); i++) {
            int u = edges.get(i).x;
            int v = edges.get(i).y;
            int cost = edges.get(i).cost;

            if (union(u, v, parent)) {
                totalCost += cost;
            }
        }

        return totalCost;
    }

    private static boolean union(int u, int v, int[] parent) {
        int rootU = findRoot(u, parent);
        int rootV = findRoot(v, parent);

        if (rootU != rootV) {
            parent[rootU] = rootV;

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
        int cost;

        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }
}
