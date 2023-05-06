package scaler.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an undirected graph having A nodes. A matrix B of size M x 2 is given which represents the edges such that there
 * is an edge between B[i][0] and B[i][1].
 * Find whether the given graph is bipartite or not.
 * A graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in
 * the graph has one node in A and another node in B
 * <p>
 * Note:
 * There are no self-loops in the graph.
 * No multiple edges between two pair of vertices.
 * The graph may or may not be connected.
 * Nodes are Numbered from 0 to A-1.
 * Your solution will run on multiple testcases. If you are using global variables make sure to clear them.
 */
public class CheckBipartiteGraph {
    public static void main(String[] args) {
        int[][] B = new int[][]{{0, 1}, {0, 2}, {1, 2}};
        System.out.println(solve(2, B));

        B = new int[][]{{0, 1}};
        System.out.println(solve(2, B));

        B = new int[][]{{7, 8}, {1, 2}, {0, 9}, {1, 3}, {6, 7}, {0, 3}, {2, 5}, {3, 8}, {4, 8}};
        System.out.println(solve(10, B));

        B = new int[][]{{5, 6}, {1, 3}, {2, 4}, {4, 5}};
        System.out.println(solve(10, B));
    }

    static int result = 1;

    //Approach is to use colouring logic. if all the nodes can be coloured using just two colour then it is a bipartite graph
    private static int solve(int A, int[][] B) {
        result = 1;
        int[] colour = new int[A + 1];

        final Map<Integer, List<Integer>> graph = new HashMap<>();

        //Forming the adjacency list
        for (int i = 0; i < B.length; i++) {
            int a = B[i][0];
            int b = B[i][1];

            //Making node from a -> b
            if (graph.containsKey(a)) {
                graph.get(a).add(b);
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(b);
                graph.put(a, list);
            }

            //Making node from b -> a
            if (graph.containsKey(b)) {
                graph.get(b).add(a);
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(a);
                graph.put(b, list);
            }
        }

        //Colour the vertices using DFS
        for (int i = 0; i < colour.length; i++) {
            if (colour[i] == 0) {
                colour[i] = -1;
                dfs(graph, colour, i);
            }

        }

        return result;
    }

    private static void dfs(Map<Integer, List<Integer>> graph, int[] colour, int v) {
        final List<Integer> neighbours = graph.get(v);

        if (neighbours == null) {
            return;
        }

        for (Integer neighbour : neighbours) {
            if (colour[v] == colour[neighbour]) {
                result = 0;
            }
            if (colour[neighbour] == 0) {
                //System.out.print(neighbour + ", ");
                colour[neighbour] = colour[v] == -1 ? -2 : -1;
                dfs(graph, colour, neighbour);
            }
        }
    }

}
