package companies.cisco;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        k = 2;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2};
        k = 1;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2};
        k = 0;
        rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }

    private static void rotate(int[] nums, int k) {
        k = k % nums.length;

        //Reverse the entire array
        reverse(nums, 0, nums.length - 1);

        //Reverse the 1st k elements
        reverse(nums, 0, k - 1);

        //Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
