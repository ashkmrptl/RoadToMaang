package scaler.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given N towns (1 to N). All towns are connected via unique directed path as mentioned in the input.
 * Given 2 towns find whether you can reach the first town from the second without repeating any edge.
 * B C : query to find whether B is reachable from C.
 * Input contains an integer array A of size N and 2 integers B and C ( 1 <= B, C <= N ).
 * There exist a directed edge from A[i] to i+1 for every 1 <= i < N. Also, it's guaranteed that A[i] <= i for every 1 <= i < N.
 * NOTE: Array A is 0-indexed. A[0] = 1 which you can ignore as it doesn't represent any edge.
 */
public class FirstDepthFirstSearch {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2};
        System.out.println(solve(A, 1, 2));

        A = new int[]{1, 1, 2};
        System.out.println(solve(A, 2, 1));
    }

    private static int solve(int[] A, final int B, final int C) {
        final List<Integer>[] graph = new List[A.length + 1];

        for (int i = 1; i < A.length; i++) {
            if (graph[A[i]] != null) {
                graph[A[i]].add(i + 1);
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(i + 1);
                graph[A[i]] = list;
            }
        }

        final boolean[] visited = new boolean[A.length + 1];

        depthFirstSearch(C, graph, visited);

        return visited[B] ? 1 : 0;
    }

    private static void depthFirstSearch(int C, List<Integer>[] graph, boolean[] visited) {
        visited[C] = true;

        if (graph[C] == null || graph[C].isEmpty()) {
            return;
        }

        for (int i = 0; i < graph[C].size(); i++) {
            int node = graph[C].get(i);

            if (!visited[node]) {
                depthFirstSearch(node, graph, visited);
            }
        }
    }
}
