package companies.cisco;

/**
 * Given an integer array nums, find the
 * subarray
 * with the largest sum, and return its sum.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6.
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

        nums = new int[]{1, 2, 3};
        System.out.println(maxSubArray(nums));

        nums = new int[]{-2, -1, -3};
        System.out.println(maxSubArray(nums));
    }

    private static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = 0;

        int i = 0;

        while (i < nums.length) {
            currentSum += nums[i];
            maxSum = Math.max(maxSum, currentSum);
            if (currentSum < 0) {
                currentSum = 0;
            }
            i++;
        }

        return maxSum;
    }

    //With pf sum array - TC: O(n * n)
    private static int maxSubArray_pf(int[] nums) {
        int[] pf = new int[nums.length];
        pf[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            pf[i] = pf[i - 1] + nums[i];
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (i - 1 >= 0) {
                    maxSum = Math.max(maxSum, pf[j] - pf[i - 1]);
                } else {
                    maxSum = Math.max(pf[j], maxSum);
                }
            }
        }

        return maxSum;
    }
}
