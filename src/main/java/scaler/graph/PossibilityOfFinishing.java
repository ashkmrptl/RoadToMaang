package scaler.graph;

import java.util.*;

/**
 * There are a total of A courses you have to take, labeled from 1 to A.
 * Some courses may have prerequisites, for example to take course 2 you have to first take course 1, which is expressed as a pair: [1,2].
 * So you are given two integer array B and C of same size where for each i (B[i], C[i]) denotes a pair.
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * Return 1 if it is possible to finish all the courses, or 0 if it is not possible to finish all the courses.
 */
public class PossibilityOfFinishing {
    public static void main(String[] args) {
        int[] B = new int[] {1, 2};
        int[] C = new int[] {2, 3};
        System.out.println(solve(3, B, C));

        B = new int[] {1, 2};
        C = new int[] {2, 1};
        System.out.println(solve(2, B, C));
    }

    private static int solve(int A, int[] B, int[] C) {
        final int[] inDegree = new int[A + 1];

        final Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            inDegree[C[i]]++;

            if(graph.containsKey(B[i])) {
                graph.get(B[i]).add(C[i]);
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(C[i]);

                graph.put(B[i], list);
            }
        }

        final Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < inDegree.length; i++) {
            if(inDegree[i] == 0) {
                queue.add(i);
            }
        }

        //BFS
        while (!queue.isEmpty()) {
            final int v = queue.poll();

            if (graph.containsKey(v)) {
                for(int e: graph.get(v)) {
                    inDegree[e]--;

                    if (inDegree[e] == 0) {
                        queue.add(e);
                    }
                }
            }
        }

        for(final int e: inDegree) {
            if(e > 0) {
                return 0;
            }
        }

        return 1;
    }
}
