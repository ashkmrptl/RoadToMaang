package scaler.graph;

import java.util.*;

/**
 * Given an directed graph having A nodes labelled from 1 to A containing M edges given by matrix B of size M x 2such that there is a edge directed from node
 * B[i][0] to node B[i][1].
 * Find whether a path exists from node 1 to node A.
 * Return 1 if path exists else return 0.
 * <p>
 * NOTE:
 * There are no self-loops in the graph.
 * There are no multiple edges between two nodes.
 * The graph may or may not be connected.
 * Nodes are numbered from 1 to A.
 * Your solution will run on multiple test cases. If you are using global variables make sure to clear them.
 */
public class PathInDirectedGraph {
    public static void main(String[] args) {
        System.out.println(solve(5, new int[][]{{1, 2}, {4, 1}, {2, 4}, {3, 4}, {5, 2}, {1, 3}}));

        System.out.println(solve(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }

    /**
     * Idea is to build the graph and the do BFS or DFS to find if a path exists.
     * The adjacency list will be used to represent the graph
     */
    private static int solve(int A, int[][] B) {
        final List<Integer>[] graph = new List[A + 1];

        for (int i = 0; i < B.length; i++) {
            int a = B[i][0];
            int b = B[i][1];

            if (graph[a] != null) {
                graph[a].add(b);
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(b);
                graph[a] = list;
            }
        }

        //Traversing(BFS)
        boolean[] visited = new boolean[A + 1];

        final Queue<Integer> queue = new LinkedList<>();

        //Adding "1" because we need to find the path from the node 1 to A.
        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            int a = queue.poll();
            final List<Integer> list = graph[a];
            if (list == null) {
                continue;
            }

            for (int i = 0; i < list.size(); i++) {
                if (!visited[list.get(i)]) {
                    queue.add(list.get(i));
                    visited[list.get(i)] = true;
                }
            }
        }

        return visited[A] ? 1 : 0;
    }
}
