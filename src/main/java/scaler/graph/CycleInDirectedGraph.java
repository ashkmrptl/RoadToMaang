package scaler.graph;

import java.util.*;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        int[][] B = new int[][]{{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3}};
        System.out.println(solve(5, B));

        B = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}};
        System.out.println(solve(5, B));

        B = new int[][]{{1, 2}, {1, 3}, {2, 3}, {1, 4}, {4, 3}, {4, 5}, {3, 5}};
        System.out.println(solve(5, B));
    }

    //Approach is to use topological sort
    private static int solve(int A, int[][] B) {
        final int[] indegree = new int[A + 1];

        for (int i = 0; i < B.length; i++) {
            indegree[B[i][1]]++;
        }

        final Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 1; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        final Map<Integer, List<Integer>> graph = createGraph(B);

        //Perform BFS
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            if (graph.containsKey(vertex)) {
                final List<Integer> neighbours = graph.get(vertex);

                //Decrease the in-degree by one for each neighbour vertices
                for (int neighbour: neighbours) {
                    indegree[neighbour]--;
                    if (indegree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        //If BFS is done and any vertex has in-degree more than zero cycle is present
        for (int i = 1; i <= A; i++) {
            if (indegree[i] > 0) {
                return 1;
            }
        }

        return 0;

    }

    private static Map<Integer, List<Integer>> createGraph(int[][] B) {
        final Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < B.length; i++) {
            if (graph.containsKey(B[i][0])) {
                graph.get(B[i][0]).add(B[i][1]);
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(B[i][1]);

                graph.put(B[i][0], list);
            }
        }

        return graph;
    }
}
