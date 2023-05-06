package companies.intuit;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        final int[] inDegree = new int[numCourses + 1];

        final Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;

            if (graph.containsKey(prerequisites[i][1])) {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], list);
            }
        }

        //BFS
        final Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();

            final List<Integer> neighbours = graph.get(v);

            if (neighbours != null) {
                for (final int neighbour : neighbours) {
                    inDegree[neighbour]--;
                    if (inDegree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        boolean can = true;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] > 0) {
                can = false;
                break;
            }
        }

        return can;
    }
}
