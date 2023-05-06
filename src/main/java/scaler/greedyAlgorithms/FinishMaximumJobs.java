package scaler.greedyAlgorithms;

import java.util.Arrays;

/**
 * There are N jobs to be done, but you can do only one job at a time.
 * Given an array A denoting the start time of the jobs and an array B denoting the finish time of the jobs.
 * Your aim is to select jobs in such a way so that you can finish the maximum number of jobs.
 * Return the maximum number of jobs you can finish.
 */
public class FinishMaximumJobs {
    public static void main(String[] args) {
        int[] A = new int[]{1, 5, 7, 1};
        int[] B = new int[]{7, 8, 8, 8};

        System.out.println(solve(A, B));

        A = new int[]{3, 2, 6};
        B = new int[]{9, 8, 9};

        System.out.println(solve(A, B));

        A = new int[]{3, 4};
        B = new int[]{5, 14};

        System.out.println(solve(A, B));
    }

    private static class Pair implements Comparable<Pair> {
        int start;
        int end;

        Pair(int s, int e) {
            this.start = s;
            this.end = e;
        }

        public int compareTo(Pair o) {
            if (this.end < o.end) {
                return -1;
            } else if (this.end > o.end) {
                return 1;
            } else {
                return 0;
            }
        }

    }

    public static int solve(int[] A, int[] B) {
        int N = A.length;
        final Pair[] activities = new Pair[N];
        for (int i = 0; i < N; i++) {
            activities[i] = new Pair(A[i], B[i]);
        }
        Arrays.sort(activities);
        int ans = 0;
        int lastActivityEnd = 0;
        for (int i = 0; i < N; i++) {
            final Pair activity = activities[i];
            if (activity.start >= lastActivityEnd) {
                lastActivityEnd = activity.end;
                ans++;
            }
        }
        return ans;

    }

    /*private static int solve(int[] A, int[] B) {

        final Pair[] pairs = new Pair[A.length];

        for (int i = 0; i < A.length; i++) {
            pairs[i] = new Pair(A[i], B[i]);
        }

        //Sort according to end time
        Arrays.sort(pairs, new MyComparator());

        int ans = 0;
        int lastActivityEnd = 0;

        for (int i = 0; i < pairs.length; i++) {
            final Pair current = pairs[i];

            if (current.start >= lastActivityEnd) {
                lastActivityEnd = current.end;
                ans++;
            }
        }
        return ans;
    }

    public static class MyComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            return Integer.compare(o1.end, o2.end);
        }
    }

    private static class Pair {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }*/
}
