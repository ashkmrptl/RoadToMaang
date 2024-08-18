package companies.microsoft;


import java.util.*;

public class NetworkDelayTime {
    public static void main(String[] args) {
        int[][] times = new int[][]{{2, 1, 1}, {2, 3, 1}, {3, 4, 1}};
        System.out.println(networkDelayTime(times, 4, 2));

        times = new int[][]{{1, 2, 1}, {2, 3, 3}, {3, 1, 1}};
        System.out.println(networkDelayTime(times, 3, 2));
    }

    private static int networkDelayTime(int[][] times, int n, int k) {
        final Map<Integer, List<Node>> graph = generateGraph(times);

        final int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        //BFS
        final Queue<Node> minHeap = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));

        //Add the start node and its distance as 0
        distance[k] = 0;
        minHeap.add(new Node(k, 0));

        while (!minHeap.isEmpty()) {
            final Node node = minHeap.poll();

            final List<Node> neighbours = graph.get(node.vertex);
            if (neighbours != null) {
                for (final Node neighbour : neighbours) {
                    int currentDistance = node.weight + neighbour.weight;
                    if (currentDistance < distance[neighbour.vertex]) {
                        distance[neighbour.vertex] = currentDistance;
                        minHeap.add(new Node(neighbour.vertex, currentDistance));
                    }
                }
            }
        }

        //Check fo unreachable node
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i < distance.length; i++) {
            ans = Math.max(distance[i], ans);
            if (distance[i] == Integer.MAX_VALUE) {
                return -1;
            }
        }

        return ans;
    }

    private static Map<Integer, List<Node>> generateGraph(final int[][] times) {
        final Map<Integer, List<Node>> graph = new HashMap<>();

        for (final int[] time : times) {
            if (graph.containsKey(time[0])) {
                graph.get(time[0]).add(new Node(time[1], time[2]));
            } else {
                final List<Node> neighbours = new ArrayList<>();
                neighbours.add(new Node(time[1], time[2]));
                graph.put(time[0], neighbours);
            }
        }

        return graph;
    }

    private static class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "(" + vertex +
                    ", " + weight +
                    ')';
        }
    }
}
