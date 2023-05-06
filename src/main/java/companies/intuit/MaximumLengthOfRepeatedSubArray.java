package companies.intuit;

import java.util.Arrays;

/**
 * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
 */
public class MaximumLengthOfRepeatedSubArray {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 2, 3, 1};
        int[] nums2 = new int[]{3, 2, 1, 4, 7};

        System.out.println(findLength(nums1, nums2));
        System.out.println(findLengthOptimized(nums1, nums2));

        nums1 = new int[]{1, 2, 3, 2, 1};
        nums2 = new int[]{3, 2, 1, 4, 7};

        System.out.println(findLength(nums1, nums2));
        System.out.println(findLengthOptimized(nums1, nums2));

        nums1 = new int[]{0, 0, 0, 0, 0};
        nums2 = new int[]{0, 0, 0, 0, 0};

        System.out.println(findLength(nums1, nums2));
        System.out.println(findLengthOptimized(nums1, nums2));
    }

    private static int findLength(int[] nums1, int[] nums2) {
        //Create the DP array
        final int[][] dp = new int[nums1.length + 1][nums2.length + 1];

        int ans = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }

        return ans;
    }

    private static int findLengthOptimized(int[] n1, int[] n2) {
        int m = n1.length;
        int n = n2.length;
        if (m < n) {
            return findLengthOptimized(n2, n1);
        }

        int ans = 0;

        final int[] dp = new int[n + 1];

        for (int i = 1; i < m + 1; i++) {
            int diagonal = 0;
            for (int j = 1; j < n + 1; j++) {
                int nextDiagonal = dp[j];
                if (n1[i - 1] == n2[j - 1]) {
                    dp[j] = 1 + diagonal;
                    ans = Math.max(ans, dp[j]);
                }
                diagonal = nextDiagonal;
            }
        }

        return ans;
    }
}
