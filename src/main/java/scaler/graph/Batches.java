package scaler.graph;

import java.util.*;

/**
 * A students applied for admission in IB Academy. An array of integers B is given representing the strengths of A people i.e. B[i] represents the strength of ith student.
 * Among the A students some of them knew each other. A matrix C of size M x 2 is given which represents relations where ith relations depicts that C[i][0] and C[i][1] knew each other.
 * All students who know each other are placed in one batch.
 * Strength of a batch is equal to sum of the strength of all the students in it.
 * Now the number of batches are formed are very much, it is impossible for IB to handle them. So IB set criteria for selection: All those batches having strength at least D are selected.
 * Find the number of batches selected.
 * NOTE: If student x and student y know each other, student y and z know each other then student x and student z will also know each other.
 */
public class Batches {
    public static void main(String[] args) {
        int A = 7;
        int[] B = new int[]{1, 6, 7, 2, 9, 4, 5};
        int[][] C = new int[][]{{1, 2}, {2, 3}, {5, 6}, {5, 7}};
        int D = 12;

        System.out.println(solve(A, B, C, D));

        A = 5;
        B = new int[]{1, 2, 3, 4, 5};
        C = new int[][]{{1, 5}, {2, 3}};
        D = 6;

        System.out.println(solve(A, B, C, D));

        A = 10;
        B = new int[]{4, 4, 4, 2, 7, 1, 5, 10, 6, 6};
        C = new int[][]{{1, 5}, {1, 8}, {2, 5}, {2, 7}, {4, 9}, {5, 9}};
        D = 1;

        System.out.println(solve(A, B, C, D));
    }

    private static int solve(int A, int[] B, int[][] C, int D) {
        final Map<Integer, List<Integer>> graph = createGraph(A, C);
        final boolean[] visited = new boolean[A + 1];

        int ans = 0;

        //Perform BFS
        for (int i = 1; i <= A; i++) {
            if (visited[i]) {
                continue;
            }

            int currentStrength = 0;
            final Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;

            while (!queue.isEmpty()) {
                final int v = queue.poll();
                currentStrength += B[v - 1];
                final List<Integer> neighbours = graph.get(v);

                for (final int neighbour : neighbours) {
                    if (!visited[neighbour]) {
                        queue.add(neighbour);
                        visited[neighbour] = true;
                    }
                }
            }

            if (currentStrength >= D) {
                ans++;
            }
        }

        return ans;
    }

    private static Map<Integer, List<Integer>> createGraph(int A, int[][] B) {
        final Map<Integer, List<Integer>> map = new HashMap<>();

        //Add empty list for each vertices
        for (int i = 1; i <= A; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];

            map.get(u).add(v);
            map.get(v).add(u);
        }

        return map;
    }
}
