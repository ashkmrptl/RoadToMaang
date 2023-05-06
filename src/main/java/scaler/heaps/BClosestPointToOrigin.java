package scaler.heaps;

import java.util.*;

public class BClosestPointToOrigin {
    public static void main(String[] args) {
        int[][] A = new int[][] {{1, 3}, {-2, 2}};
        System.out.println(Arrays.deepToString(solve(A, 1)));

        A = new int[][] {{1, -1}, {2, -1}};
        System.out.println(Arrays.deepToString(solve(A, 1)));
    }

    private static ArrayList<ArrayList<Integer>> solve(ArrayList<ArrayList<Integer>> A, int B) {
        final Queue<PointDistancePair> minHeap = new PriorityQueue<>(new MyComparator());//new PriorityQueue<>(Comparator.comparingDouble(pair -> pair.distance));

        for (int i = 0; i < A.size(); i++) {
            ArrayList<Integer> pointList = A.get(i);
            int x = pointList.get(0);
            int y = pointList.get(1);

            double distance = Math.sqrt(((x - 0) * (x - 0)) + ((y - 0) * (y - 0)));

            final PointDistancePair pair = new PointDistancePair(pointList, null, distance);
            minHeap.add(pair);
        }

        final ArrayList<ArrayList<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            answer.add(minHeap.poll().pointList);
        }

        return answer;
    }

    private static int[][] solve(int[][] A, int B) {
        final Queue<PointDistancePair> minHeap = new PriorityQueue<>(new MyComparator());//new PriorityQueue<>(Comparator.comparingDouble(pair -> pair.distance));

        for (int i = 0; i < A.length; i++) {
            int[] point = A[i];
            int x = point[0];
            int y = point[1];

            double distance = Math.sqrt(((x - 0) * (x - 0)) + ((y - 0) * (y - 0)));

            final PointDistancePair pair = new PointDistancePair(null, point, distance);
            minHeap.add(pair);
        }

        final List<int[]> answer = new ArrayList<>();
        for (int i = 0; i < B; i++) {
            answer.add(minHeap.poll().pointArray);
        }

        int[][] ans = new int[answer.size()][2];
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }

        return ans;
    }

    private static class MyComparator implements Comparator<PointDistancePair> {

        @Override
        public int compare(PointDistancePair o1, PointDistancePair o2) {
            return Double.compare(o1.distance, o2.distance);
        }
    }

    private static class PointDistancePair {
        double distance;
        int[] pointArray;
        ArrayList<Integer> pointList;

        public PointDistancePair(ArrayList<Integer> pointList, int[] point, double distance) {
            this.pointArray = point;
            this.distance = distance;
            this.pointList = pointList;
        }
    }
}
