package companies.intuit;

import java.util.*;
import java.util.stream.Collectors;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        System.out.println(Arrays.deepToString(merge(intervals)));
        System.out.println(Arrays.deepToString(merge_faster(intervals)));
    }

    /**
     * Below approach is faster but with same time complexity
     */
    private static int[][] merge_faster(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(array -> array[0]));

        final List<int[]> list = Arrays.stream(intervals).collect(Collectors.toCollection(LinkedList::new));


        int i = 0;
        while (i < list.size() - 1) {
            int[] curr = list.get(i);
            int[] next = list.get(i + 1);

            if (curr[1] >= next[0]) {//overlap
                final int[] merged = new int[]{Math.min(curr[0], next[0]), Math.max(curr[1], next[1])};
                list.remove(i);
                list.remove(i);

                list.add(i, merged);
            } else {
                i++;
            }
        }

        final int[][] result = new int[list.size()][2];
        for (int j = 0; j < result.length; j++) {
            result[j] = list.get(j);
        }

        return result;
    }

    private static int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }

        Arrays.sort(intervals, Comparator.comparingInt(array -> array[0]));

        final List<int[]> list = new ArrayList<>();
        int[] curr = intervals[0];
        int[] next = intervals[1];

        if (curr[1] >= next[0]) {//overlap
            if (curr[1] < next[1]) {
                list.add(new int[]{curr[0], next[1]});
            } else {
                list.add(curr);
            }
        } else {
            list.add(curr);
            list.add(next);
        }

        for (int i = 2; i < intervals.length; i++) {
            int[] a = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            int[] b = intervals[i];

            if (a[1] >= b[0]) {//overlap
                if (a[1] < b[1]) {
                    list.add(new int[]{a[0], b[1]});
                } else {
                    list.add(a);
                }
            } else {
                list.add(a);
                list.add(b);
            }
        }

        final int[][] result = new int[list.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }

        return result;
    }

}
