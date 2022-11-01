package scaler.array;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeOverlappingIntervals {
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
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(9, 18));

        System.out.println(solve(intervals));

        intervals = new ArrayList<>();
        intervals.add(new Interval(2, 100));
        intervals.add(new Interval(100, 100));

        System.out.println(solve(intervals));
    }

    public static ArrayList<Interval> solve(ArrayList<Interval> intervals) {
        //Sorting the intervals by their starting point
        intervals.sort(Comparator.comparingInt(interval -> interval.start));

        int i = 0;

        while (i < intervals.size() - 1) {
            Interval interval = intervals.get(i);
            Interval nextInterval = intervals.get(i + 1);

            if (interval.end >= nextInterval.start) {
                Interval newInterval = new Interval(Math.min(interval.start, nextInterval.start), Math.max(interval.end, nextInterval.end));

                intervals.remove(i);
                intervals.remove(i);
                intervals.add(i, newInterval);

            } else {
                i++;
            }
        }

        return intervals;
    }
}
