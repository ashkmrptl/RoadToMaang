package companies.microsoft;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println(canFinish(numCourses, prerequisites));
    }

    private static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses + 1];

        final Map<Integer, List<Integer>> graph = new HashMap<>();

        for (int[] prerequisite : prerequisites) {
            indegree[prerequisite[0]]++;

            if (graph.containsKey(prerequisite[1])) {
                graph.get(prerequisite[1]).add(prerequisite[0]);
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(prerequisite[0]);
                graph.put(prerequisite[1], list);
            }
        }

        //BFS
        final Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int vertex = queue.poll();

            final List<Integer> neighbours = graph.get(vertex);

            if (neighbours != null) {
                for (final int neighbour : neighbours) {
                    indegree[neighbour]--;
                    if (indegree[neighbour] == 0) {
                        queue.add(neighbour);
                    }
                }
            }
        }

        boolean can = true;
        for (int j : indegree) {
            if (j > 0) {
                can = false;
                break;
            }
        }

        return can;
    }
}
