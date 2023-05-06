package scaler.graph;

import java.util.*;

public class ReversingEdges {
    public static void main(String[] args) {
        int[][] B = new int[][]{{1, 2}, {2, 3}, {4, 3}, {4, 5}};
        System.out.println(solve(5, B));

        B = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(solve(5, B));
    }

    private static int solve(int A, int[][] B) {
        final Map<Integer, List<Pair>> graph = createDirectedWeightedGraph(A, B);

        //Apply Dijsktra to get the shortest path and the total distance is the answer
        final int[] distance = new int[A + 1];

        //Set distance of source to ZERO
        distance[1] = 0;

        //Fill distance with max(infinity)
        for (int i = 2; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        //Perform BSF using min heap(priority queue works as mean heap in java)
        final Queue<Pair> minHeap = new PriorityQueue<>(Comparator.comparing(pair -> pair.weight));

        //Add source to min heap with weight of ZERO
        minHeap.add(new Pair(1, 0));

        while (!minHeap.isEmpty()) {
            final Pair pair = minHeap.poll();

            final int node = pair.node;
            final int weight = pair.weight;

            if (distance[node] == weight) {
                for (final Pair neighbour : graph.get(node)) {
                    if (distance[node] + neighbour.weight < distance[neighbour.node]) {
                        distance[neighbour.node] = distance[node] + neighbour.weight;
                        minHeap.add(new Pair(neighbour.node, distance[neighbour.node]));

                        //Check if source is reached
                        if (neighbour.node == A) {
                            return distance[neighbour.node];
                        }
                    }
                }
            }
        }

        if (distance[A] == Integer.MAX_VALUE) {
            return -1;
        }

        return 0;
    }

    private static Map<Integer, List<Pair>> createDirectedWeightedGraph(int A, int[][] B) {
        final Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int i = 1; i <= A; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            int a = B[i][0];
            int b = B[i][1];

            graph.get(a).add(new Pair(b, 0));
            graph.get(b).add(new Pair(a, 1));
        }

        return graph;
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
}
