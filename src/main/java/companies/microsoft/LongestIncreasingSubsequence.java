package companies.microsoft;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));

        nums = new int[]{1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS(nums));
    }

    private static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int ans = 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < nums.length) {
                if (nums[i] < nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
                j++;
            }
        }

        return ans;
    }
}
