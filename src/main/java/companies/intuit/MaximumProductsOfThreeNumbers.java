package companies.intuit;

import java.util.Arrays;

/**
 * Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
 */
public class MaximumProductsOfThreeNumbers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(maximumProduct(nums));

        nums = new int[]{1, 2, 3, 4};
        System.out.println(maximumProduct(nums));

        nums = new int[]{-1, -2, -3};
        System.out.println(maximumProduct(nums));
    }

    private static int maximumProduct(int[] nums) {
        if (nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }

        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;

        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            } else if (nums[i] > secondMax) {
                thirdMax = secondMax;
                secondMax = nums[i];
            } else if (nums[i] > thirdMax) {
                thirdMax = nums[i];
            }

            if (nums[i] < firstMin) {
                secondMin = firstMin;
                firstMin = nums[i];
            } else if (nums[i] < secondMin) {
                secondMin = nums[i];
            }
        }

        return Math.max(firstMin * secondMin * firstMax, firstMax * secondMax * thirdMax);
    }
}
