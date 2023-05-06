package scaler.graph;

import java.util.ArrayList;

/**
 * Given an undirected graph having A nodes labelled from 1 to A with M edges given in a form
 * of matrix B of size M x 2 where (B[i][0], B[i][1]) represents two nodes B[i][0] and B[i][1] connected by an edge.
 * <p>
 * Find whether the graph contains a cycle or not, return 1 if cycle is present else return 0.
 */
public class CycleInUndirectedGraph {
    public static void main(String[] args) {
        int A = 3;
        int[][] B = new int[][]{{1, 2}, {1, 3}};
        System.out.println(solve(A, B));

        A = 5;
        B = new int[][]{{1, 3}, {1, 4}, {3, 2}, {3, 5}};
        System.out.println(solve(A, B));
    }

    static boolean[] visited;
    static boolean isCycle;
    static ArrayList<Integer>[] graph;

    private static int solve(int A, int[][] B) {
        isCycle = false;
        graph = createGraph(A, B);
        visited = new boolean[A + 1];
        return isCycleInUndirectedGraph(A) ? 1 : 0;
    }

    private static boolean isCycleInUndirectedGraph(int A) {
        for (int i = 1; i <= A; i++) {
            if (!visited[i]) {
                dfs(i, 0);
            }
            if (isCycle) {
                break;
            }
        }
        return isCycle;
    }

    private static boolean dfs(int v, int previous) {
        visited[v] = true;
        for (int u : graph[v]) {
            if (u != previous) {
                if (!visited[u]) {
                    dfs(u, v);
                } else {
                    isCycle = true;
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayList<Integer>[] createGraph(int A, int[][] B) {
        ArrayList<Integer>[] graph = new ArrayList[A + 1];
        for (int i = 0; i <= A; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] num : B) {
            int a = num[0];
            int b = num[1];
            graph[a].add(b);
            graph[b].add(a);
        }
        return graph;
    }
}
