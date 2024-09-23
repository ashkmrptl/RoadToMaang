package companies.microsoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 6, 9, 12};
        //System.out.println(longestArithSeqLength_bf(nums));
        //System.out.println(longestArithSeqLength(nums));

        nums = new int[]{9, 4, 7, 2, 10};
        //System.out.println(longestArithSeqLength_bf(nums));
        //System.out.println(longestArithSeqLength(nums));

        nums = new int[]{20, 1, 15, 3, 10, 5, 8};
        //System.out.println(longestArithSeqLength_bf(nums));
        //System.out.println(longestArithSeqLength(nums));

        nums = new int[]{83, 20, 17, 43, 52, 78, 68, 45};
        System.out.println(longestArithSeqLength(nums));
    }

    private static int longestArithSeqLength(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int ans = 2;

        final Map<Integer, Integer>[] dp = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap<>();
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[i] - nums[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                ans = Math.max(ans, dp[i].get(diff));
            }
        }

        return ans;
    }

    private static int longestArithSeqLength_bf(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                ans = Math.max(ans, count_bf(i, nums[j] - nums[i], nums) + 2);
            }
        }

        return ans;
    }

    private static int count_bf(int index, int diff, int[] nums) {
        if (index < 0) {
            return 0;
        }

        int count = 0;

        for (int i = index - 1; i >= 0; i--) {
            if (nums[index] - nums[i] == diff) {
                count = Math.max(count, 1 + count_bf(i, diff, nums));
            }
        }

        return count;
    }
}
