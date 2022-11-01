package scaler.array;

import java.util.ArrayList;

/**
 * Problem Description
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Problem Constraints
 * 0 <= |intervals| <= 105
 * <p>
 * Input Format
 * First argument is the vector of intervals
 * second argument is the new interval to be merged
 * <p>
 * Output Format
 * Return the vector of intervals after merging
 * <p>
 * Example Input
 * Input 1:
 * Given intervals [1, 3], [6, 9] insert and merge [2, 5] .
 * Input 2:
 * Given intervals [1, 3], [6, 9] insert and merge [2, 6] .
 * <p>
 * Example Output
 * Output 1:
 * [ [1, 5], [6, 9] ]
 * Output 2:
 * [ [1, 9] ]
 * <p>
 * Example Explanation
 * Explanation 1:
 * (2,5) does not completely merge the given intervals
 * Explanation 2:
 * (2,6) completely merges the given intervals
 */
public class MergeIntervals {
    static class Interval {
        int start;
        int end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", start, end);
        }
    }

    public static void main(String[] args) {
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        Interval newInterval = new Interval(2, 5);
        System.out.println(solve(intervals, newInterval));

        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        newInterval = new Interval(2, 6);
        System.out.println(solve(intervals, newInterval));

        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        newInterval = new Interval(2, 7);
        System.out.println(solve(intervals, newInterval));

        intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(6, 9));

        newInterval = new Interval(1, 9);
        System.out.println(solve(intervals, newInterval));
    }

    private static ArrayList<Interval> solve(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();
        int i = 0;

        while (i < intervals.size()) {
            Interval interval = intervals.get(i);

            if (newInterval.end <= interval.start) {//new interval at the left
                ans.add(newInterval);
                while (i < intervals.size()) {
                    ans.add(intervals.get(i));
                    i++;
                }
                return ans;
            } else if (interval.end <= newInterval.start) {//new interval at the right
                ans.add(interval);
                i++;
            } else {//overlapping
                //Merge
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
                i++;
            }
        }
        ans.add(newInterval);
        return ans;
    }
}
