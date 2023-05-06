package scaler.graph;

import java.util.*;

public class KruskalMinimumSpanningTree {
    public static void main(String[] args) {
        int A = 6;

        int[][] B = new int[][]{{1, 2, 1}, {1, 4, 4}, {1, 5, 3}, {2, 5, 2}, {2, 4, 4}, {3, 5, 4}, {3, 6, 5}, {4, 5, 4}, {5, 6, 7}};

        final Map<Integer, List<Pair>> mst = solve(A, B);
    }

    private static Map<Integer, List<Pair>> solve(int A, int[][] B) {
        //Sort the edges of the graph by their weights
        final List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < B.length; i++) {
            int x = B[i][0];
            int y = B[i][1];
            int weight = B[i][2];

            final Edge edge = new Edge(x, y, weight);

            edges.add(edge);
        }

        edges.sort(Comparator.comparingInt(edge -> edge.weight));

        //Create the parent array and initially set itself as parent of each node.
        final int[] parent = new int[A + 1];

        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        final Map<Integer, List<Pair>> mst = new HashMap<>();

        //Traverse the edge array
        for (int i = 0; i < edges.size(); i++) {
            final int u = edges.get(i).x;
            final int v = edges.get(i).y;
            final int weight = edges.get(i).weight;

            if (union(u, v, parent)) {//if union returns true select the edge
                totalCost += weight;

                //Add edge to the graph
                if (mst.containsKey(u)) {
                    mst.get(u).add(new Pair(v, weight));
                } else {
                    final List<Pair> list = new ArrayList<>();
                    list.add(new Pair(v, weight));
                    mst.put(u, list);
                }
            }
        }

        System.out.println("total cost of MST : " + totalCost);

        return mst;
    }

    private static boolean union(int node1, int node2, int[] parent) {
        int root1 = findRootByPathCompression(node1, parent); //findRoot(node1, parent);
        int root2 = findRootByPathCompression(node2, parent); //findRoot(node2, parent);

        //If roots are different merge the edge i.e. make "node2 parent of node1" or "node1 parent of node2"
        if (root1 != root2) {
            parent[root1] = root2;
            return true;
        }

        return false;
    }

    private static int findRoot(int node, int[] parent) {
        while (node != parent[node]) {
            node = parent[node];
        }

        return node;
    }

    //The just find method has the TC of height of the tree, this can be optimized by path compression method
    private static int findRootByPathCompression(int node, int[] parent) {
        if (node == parent[node]) {
            return node;
        }

        parent[node] = findRootByPathCompression(parent[node], parent);

        return parent[node];
    }

    private static class Pair {
        int node;
        int weight;

        public Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + node + ", " + weight + ")";
        }
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
