package companies.visa;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of distinct integers and a target, return the number of possible combinations that add up to target
 */
public class CombinationSumIV {
    static int count = 0;

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }

    private static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);

        return count(nums, target, dp);
    }

    private static int count(int[] nums, int target, int[] dp) {
        if (target < 0) {
            return 0;
        } else if (target == 0) {
            return 1;
        }

        if (dp[target] != -1) {
            return dp[target];
        }

        int sum = 0;
        for (int num : nums) {
            sum += count(nums, target - num, dp);
        }
        dp[target] = sum;

        return dp[target];
    }

    private static int combinationSum4_more_time(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//Base case(i.e. for sum zero)

        for (int i = 1; i <= target; i++) {
            map.put(i, 0);
            for (int num : nums) {
                System.out.println("map.get(" + i + ") = " + map.get(i));
                map.put(i, map.get(i) + map.getOrDefault(i - num, 0));
            }
        }

        return map.get(target);
    }

    //Following is brute force way(optimized the DP(can be done with both up down and bottom up approach))
    private static void backtrack(int[] nums, int target, int sum) {
        if (sum == target) {
            count++;
            return;
        } else if (sum > target) {
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            backtrack(nums, target, sum);
            sum = sum - nums[i];
        }
    }
}
