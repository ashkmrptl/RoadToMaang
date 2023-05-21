package companies.cisco;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Given an array of intervals where intervals[i] = [start[i], end[i]]. merge all overlapping intervals and return an array of the
 * non-overlapping intervals that cover all the intervals in the input.
 * Example 1:
 * <p>
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 */
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));

        intervals = new int[][]{{1, 4}, {4, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));

        intervals = new int[][]{{1, 4}, {0, 0}};
        System.out.println(Arrays.deepToString(merge(intervals)));
    }

    private static int[][] merge(int[][] intervals) {
        //Sort the intervals based on the starting time
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));

        int[] prev = intervals[0];
        final List<int[]> list = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (prev[1] >= current[0]) {
                prev[1] = Math.max(current[1], prev[1]);
            }else {
                list.add(prev);
                prev = intervals[i];
            }
        }

        list.add(prev);

        int[][] retArray = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            retArray[i][0] = list.get(i)[0];
            retArray[i][1] = list.get(i)[1];
        }
        return retArray;
    }
}
