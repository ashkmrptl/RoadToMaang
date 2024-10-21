package companies.walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 1235. Maximum Profit in Job Scheduling
 * https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
        int[] startTime = new int[]{1,2,3,4,6};
        int[] endTime = new int[]{3,5,10,6,9};
        int[] profit = new int[]{20,20,100,70,60};

        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    private static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        final List<Schedule> schedules = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            schedules.add(new Schedule(startTime[i], endTime[i], profit[i]));
        }

        //Sort schedule by start time
        schedules.sort(Comparator.comparingInt(schedule -> schedule.start));

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return scheduleRecursively(schedules, 0, n, dp);
    }

    private static int scheduleRecursively(List<Schedule> schedules, int index, int n, int[] dp) {
        if (index >= n) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        final Schedule currentSchedule = schedules.get(index);

        int nextIndex = binarySearchNextScheduleIndex(schedules, index + 1, currentSchedule.end);
        int taken = currentSchedule.profit + scheduleRecursively(schedules, nextIndex, n, dp);

        int notTaken = scheduleRecursively(schedules, index + 1, n, dp);

        dp[index] = Math.max(taken, notTaken);

        return dp[index];
    }

    private static int binarySearchNextScheduleIndex(List<Schedule> schedules, int left, int currentJobEnd) {
        int right = schedules.size() - 1;

        int result = Integer.MAX_VALUE;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (schedules.get(mid).start >= currentJobEnd) {//We can take this job
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }


    private static int jobScheduling_TLE(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        final List<Schedule> schedules = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            schedules.add(new Schedule(startTime[i], endTime[i], profit[i]));
        }

        //Sort schedules by their end time
        schedules.sort(Comparator.comparingInt(s -> s.end));

        int maxProfit = 0;
        int[] maxProfits = new int[n];
        for (int i = 0; i < n; i++) {
            maxProfits[i] = schedules.get(i).profit;
            maxProfit = Math.max(maxProfit, maxProfits[i]);
        }

        int l = 0;
        int r = 1;

        while (r < n) {
            if (!isOverlapping(schedules.get(l), schedules.get(r))) {
                maxProfits[r] = Math.max(maxProfits[r], maxProfits[l] + schedules.get(r).profit);
                maxProfit = Math.max(maxProfit, maxProfits[r]);
                l++;
            } else if (l == r - 1) {
                r++;
                l = 0;
            } else {
                r++;
                l = 0;
            }
        }

        return maxProfit;
    }

    private static boolean isOverlapping(Schedule s1, Schedule s2) {
        return s1.end > s2.start;
    }

    private static class Schedule {
        int start;
        int end;
        int profit;

        public Schedule(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }

        @Override
        public String toString() {
            return start + " " + end + " " + profit;
        }
    }
}
