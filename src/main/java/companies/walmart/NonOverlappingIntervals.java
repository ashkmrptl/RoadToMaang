package companies.walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 435. Non-overlapping Intervals
 * https://leetcode.com/problems/non-overlapping-intervals/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class NonOverlappingIntervals {
    private static int minCount = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        //System.out.println(eraseOverlapIntervals_bruteForce(intervals));
        System.out.println(eraseOverlapIntervals(intervals));

        minCount = Integer.MAX_VALUE;
        intervals = new int[][]{{1, 2}, {1, 2}, {1, 2}};
        //System.out.println(eraseOverlapIntervals_bruteForce(intervals));
        System.out.println(eraseOverlapIntervals(intervals));

        minCount = Integer.MAX_VALUE;
        intervals = new int[][]{{1, 2}, {2, 3}};
        //System.out.println(eraseOverlapIntervals_bruteForce(intervals));
        System.out.println(eraseOverlapIntervals(intervals));

        minCount = Integer.MAX_VALUE;
        intervals = new int[][]{{40, 70}, {56, 80}, {63, 87}, {-51, 39}, {-74, 59}, {38, 41}, {-49, 17}, {6, 57}, {36, 85}, {-73, 26}, {-6, 70}, {15, 70}, {66, 78}, {37, 87}, {79, 96}, {46, 97}, {36, 49}, {-58, 40}, {-58, 52}, {26, 83}, {-27, 43}, {15, 86}, {11, 56}, {23, 34}, {-9, 73}, {-95, -75}, {2, 30}, {-91, 26}, {88, 89}, {-83, -43}};
        //System.out.println(eraseOverlapIntervals_bruteForce(intervals));
        System.out.println(eraseOverlapIntervals(intervals));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        sortByEndTime(intervals);

        int i = 0;
        int j = i + 1;

        int count = 0;

        while (j < intervals.length) {
            int[] interval1 = intervals[i];
            int[] interval2 = intervals[j];

            if (interval1[1] > interval2[0]) {
                count++;
            } else {
                i = j;
            }
            j++;
        }

        return count;
    }

    private static int eraseOverlapIntervals_bruteForce(int[][] intervals) {
        int[][] sortedIntervals = sortByEndTime(intervals);
        subsequence(sortedIntervals, 0, new ArrayList<>());

        return minCount;
    }

    private static void subsequence(int[][] intervals, int index, List<int[]> current) {
        if (index == intervals.length) {
            //Check if the intervals are non-overlapping
            boolean isNonOverlapping = checkForOverlapping(current);
            if (isNonOverlapping) {
                minCount = Math.min(minCount, intervals.length - current.size());
            }
            return;
        }

        //Exclude the current element
        subsequence(intervals, index + 1, current);

        //Include the current element
        current.add(intervals[index]);

        subsequence(intervals, index + 1, current);

        current.remove(current.size() - 1);
    }

    private static boolean checkForOverlapping(List<int[]> current) {
        if (current.isEmpty()) {
            return false;
        }

        for (int i = 0; i < current.size() - 1; i++) {
            int[] interval1 = current.get(i);
            int[] interval2 = current.get(i + 1);

            if (interval1[1] > interval2[0]) {
                return false;
            }
        }

        return true;
    }

    private static int[][] sortByEndTime(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[1]));
        return intervals;
    }
}
