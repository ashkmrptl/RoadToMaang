package companies.walmart;

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        System.out.println(minSubarrayLen(7, nums));

        nums = new int[]{1, 4, 4};
        System.out.println(minSubarrayLen(1, nums));

        nums = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubarrayLen(11, nums));

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(minSubarrayLen(11, nums));
    }

    private static int minSubarrayLen(int target, int[] nums) {
        int i = 0;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int j = 0; j < nums.length; j++) {
            currSum = currSum + nums[j];

            //Shrink the window if the currentSum exceed target
            while (currSum >= target) {
                minLength = Math.min(minLength, j - i + 1);
                currSum = currSum - nums[i];
                i++;
            }
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}
