package companies.walmart;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf_copied(nums)));

        nums = new int[]{-1, 1, 0, -3, 3};
        System.out.println(Arrays.toString(productExceptSelf_copied(nums)));
    }

    public static int[] productExceptSelf_copied(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 1;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                left = left*nums[i - 1];
            }
            res[i] = left;
        }
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i != n - 1) {
                right = right*nums[i + 1];
            }
            res[i] = res[i]*right;
        }
        return res;
    }

    private static int[] productArray(int[] nums) {
        int product = 1;
        int productWithoutZeros = 1;
        int zeroCount = 0;

        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            if (nums[i] != 0) {
                productWithoutZeros *= nums[i];
            } else {
                zeroCount++;
            }
        }
        int[] ans = new int[nums.length];

        if (product == productWithoutZeros) {
            for (int i = 0; i < nums.length; i++) {
                ans[i] = product / nums[i];
            }
        } else {
            if (zeroCount > 1) {
                Arrays.fill(ans, 0);
            } else {
                for (int i = 0; i < nums.length; i++) {
                    if (nums[i] == 0) {
                        ans[i] = productWithoutZeros;
                    } else {
                        ans[i] = 0;
                    }
                }
            }
        }

        return ans;
    }
}
