package companies.walmart;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));

        nums = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    private static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int prefixMul = 1;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                prefixMul = prefixMul * nums[i - 1];
            }
            result[i] = prefixMul;
        }

        int postfixMul = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1) {
                postfixMul = postfixMul * nums[i + 1];
            }
            result[i] = result[i] * postfixMul;
        }

        return result;
    }
}
