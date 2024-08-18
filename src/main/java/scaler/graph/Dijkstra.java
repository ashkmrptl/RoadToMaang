package scaler.graph;

import java.util.*;

/**
 * Given a weighted undirected graph having A nodes and M weighted edges, and a source node C.
 * <p>
 * You have to find an integer array D of size A such that:
 * => D[i] : Shortest distance form the C node to node i.
 * => If node i is not reachable from C then -1.
 * <p>
 * Input Format
 * The first argument given is an integer A, representing the number of nodes.
 * The second argument given is the matrix B of size M x 3, where nodes B[i][0] and B[i][1] are connected with an edge of weight B[i][2].
 * The third argument given is an integer C.
 */
public class Dijkstra {
    public static void main(String[] args) {
        int[][] B = new int[][]{{0, 4, 9}, {3, 4, 6}, {1, 2, 1}, {2, 5, 1}, {2, 4, 5}, {0, 3, 7}, {0, 1, 1}, {4, 5, 7}, {0, 5, 1}};
        System.out.println(Arrays.toString(solve(6, B, 4)));
        System.out.println(Arrays.toString(solve_again(6, B, 4)));

        B = new int[][]{{0, 3, 4}, {2, 3, 3}, {0, 1, 9}, {3, 4, 10}, {1, 3, 8}};
        System.out.println(Arrays.toString(solve(5, B, 4)));
        System.out.println(Arrays.toString(solve_again(5, B, 4)));
    }

    private static int[] solve_again(int A, int[][] B, int C) {
        final Map<Integer, List<Pair>> graph = createGraph(A, B);

        //Create distance array for tracing the shortest path
        int[] distance = new int[A];

        //Set all distance except source as infinity
        for (int i = 0; i < distance.length; i++) {
            if (i != C) {
                distance[i] = Integer.MAX_VALUE;
            }
        }

        //Start BFS from source
        final Queue<Pair> queue = new PriorityQueue<>(Comparator.comparingInt(pair -> pair.weight));
        queue.add(new Pair(C, 0));//Distance of source from itself is 0, hence weight added is 0.

        while (!queue.isEmpty()) {
            final Pair pair = queue.poll();
            int v = pair.vertex;
            int w = pair.weight;

            for (final Pair neighbour: graph.get(v)) {
                int currDistance = w + neighbour.weight;
                if (currDistance < distance[neighbour.vertex]) {
                    distance[neighbour.vertex] = currDistance;
                    queue.add(new Pair(neighbour.vertex, currDistance));
                }
            }
        }

        //Replace unreachable nodes with -1;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    private static Map<Integer, List<Pair>> createGraph(int A, int[][] B) {
        final Map<Integer, List<Pair>> graph = new HashMap<>();

        for (int i = 0; i < A; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            int w = B[i][2];

            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }

        return graph;
    }

    private static int[] solve(int A, int[][] B, int C) {
        final Map<Integer, List<Pair>> graph = new HashMap<>();

        //Build graph
        for (int i = 0; i < B.length; i++) {
            int a = B[i][0];
            int b = B[i][1];
            int w = B[i][2];

            //a -> b
            if (graph.containsKey(a)) {
                graph.get(a).add(new Pair(b, w));
            } else {
                final List<Pair> list = new ArrayList<>();
                list.add(new Pair(b, w));

                graph.put(a, list);
            }

            //b -> a
            if (graph.containsKey(b)) {
                graph.get(b).add(new Pair(a, w));
            } else {
                final List<Pair> list = new ArrayList<>();
                list.add(new Pair(a, w));

                graph.put(b, list);
            }
        }

        //Distance matrix for tracking shortest path
        final int[] distance = new int[A];
        final PriorityQueue<Pair> priorityQueue = new PriorityQueue<>((o1, o2) -> o1.weight < o2.weight ? 1 : -1);

        for (int i = 0; i < A; i++) {
            distance[i] = Integer.MAX_VALUE;
        }

        distance[C] = 0;
        priorityQueue.add(new Pair(C, 0));

        //Start BFS from source
        while (!priorityQueue.isEmpty()) {
            final Pair pair = priorityQueue.poll();
            final int vertex = pair.vertex;
            final int currentDistance = pair.weight;

            if (graph.containsKey(vertex)) {
                for (Pair p : graph.get(vertex)) {
                    int node = p.vertex;
                    int weight = p.weight;

                    if (currentDistance + weight < distance[node]) {
                        distance[node] = currentDistance + weight;
                        priorityQueue.add(new Pair(node, distance[node]));
                    }
                }
            }
        }

        //Replace unreachable nodes with -1;
        for (int i = 0; i < distance.length; i++) {
            if (distance[i] == Integer.MAX_VALUE) {
                distance[i] = -1;
            }
        }

        return distance;
    }

    private static class Pair {
        int vertex;
        int weight;

        public Pair(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return vertex + ", " + weight;
        }
    }

}
