package companies.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to n - 1 and return them in any order.)
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * <p>
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 */
public class AllPathFromSourceToTarget {
    public static void main(String[] args) {
        int[][] graph = new int[][]{{1, 2}, {3}, {3}, {}};
        System.out.println(allPathsSourceTarget(graph));

        graph = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(allPathsSourceTarget(graph));
    }

    private static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        final List<List<Integer>> result = new ArrayList<>();

        final List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph, 0, path, result);

        return result;
    }

    private static void dfs(int[][] graph, Integer node, List<Integer> path, List<List<Integer>> ans) {
        if (node == null) {
            path = new ArrayList<>();
            return;
        }

        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(path));
            path = new ArrayList<>();
            return;
        }

        int[] neighbours = graph[node];
        for (int neighbour : neighbours) {
            path.add(neighbour);
            dfs(graph, neighbour, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
