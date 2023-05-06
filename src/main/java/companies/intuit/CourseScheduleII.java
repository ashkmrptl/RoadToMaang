package companies.intuit;

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(Arrays.toString(findOrder(numCourses, prerequisites)));
    }

    /**
     * This is a graph question. Like cycle detection in graph.
     */
    private static int[] findOrder(int numCourses, int[][] prerequisites) {
        final int[] inDegree = new int[numCourses];

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

        //Start BFS
        final List<Integer> answer = new ArrayList<>();

        final Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
                answer.add(i);
            }
        }

        while (!queue.isEmpty()) {
            final int node = queue.poll();
            final List<Integer> neighbours = graph.get(node);

            if (neighbours != null) {
                for (final int neighbour : neighbours) {
                    inDegree[neighbour]--;
                    if (inDegree[neighbour] == 0) {
                        queue.add(neighbour);
                        answer.add(neighbour);
                    }
                }
            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] > 0) {
                return new int[]{};
            }
        }

        final int[] res = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            res[i] = answer.get(i);
        }
        return res;
    }
}
