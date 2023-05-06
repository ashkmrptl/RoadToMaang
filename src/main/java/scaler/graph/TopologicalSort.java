package scaler.graph;

import java.util.*;

/**
 * Given a directed acyclic graph having A nodes. A matrix B of size M x 2 is given which represents the M edges such
 * that there is an edge directed from node B[i][0] to node B[i][1].
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed
 * edge uv, vertex u comes before v in the ordering. Topological Sorting for a graph is not possible if the graph is not a DAG.
 * Return the topological ordering of the graph and if it doesn't exist then return an empty array.
 * If there is a solution return the correct ordering. If there are multiple solutions print the lexicographically smallest one.
 * <p>
 * Ex: A = 6
 * B = [  [6, 3]
 * [6, 1]
 * [5, 1]
 * [5, 2]
 * [3, 4]
 * [4, 2] ]
 * <p>
 * O/P: [5, 6, 1, 3, 4, 2]
 */
public class TopologicalSort {
    public static void main(String[] args) {
        int[][] B = new int[][]{{6, 3}, {6, 1}, {5, 1}, {5, 2}, {3, 4}, {4, 2}};
        System.out.println(Arrays.toString(solve(6, B)));

        B = new int[][]{{1, 2}, {2, 3}, {3, 1}};
        System.out.println(Arrays.toString(solve(3, B)));

        B = new int[][]{{1, 4}, {1, 2}, {4, 2}, {4, 3}, {3, 2}, {5, 2}, {3, 5}, {8, 2}, {8, 6 }};
        System.out.println(Arrays.toString(solve(8, B)));
    }

    private static int[] solve(int A, int[][] B) {
        //Build the graph and in-degree array
        int[] inDegree = new int[A + 1];
        final Map<Integer, List<Integer>> graph = new HashMap<>();

        //Generate graph and in-degree array
        for (int i = 0; i < B.length; i++) {
            int a = B[i][0];
            int b = B[i][1];

            inDegree[b]++;

            if (graph.containsKey(a)) {
                graph.get(a).add(b);
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(b);
                graph.put(a, list);
            }
        }

        //Sort the lists in the graph for lexicographical order
        /*for (final Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
            Collections.sort(entry.getValue());
        }*/

        final Queue<Integer> queue = new PriorityQueue<>();

        //Add all the elements with in-degree 0 to the queue
        for (int i = 1; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        final List<Integer> result = new ArrayList<>();

        //Perform BFS and update the in-degree
        while (!queue.isEmpty()) {
            int v = queue.poll();
            result.add(v);

            if (graph.containsKey(v)) {
                for (int u : graph.get(v)) {
                    inDegree[u]--;

                    if (inDegree[u] == 0) {
                        queue.add(u);
                    }
                }
            }
        }

        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }

        return res;
    }
}
