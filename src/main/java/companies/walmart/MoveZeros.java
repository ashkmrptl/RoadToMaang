package companies.walmart;

import java.util.Arrays;

/**
 * Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * Note that you must do this in-place without making a copy of the array.
 * Example 1:
 * <p>
 * Input: nums = [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 */
public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{0, 1, 0, 3, 12, 0};
        moveZeros(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void moveZeros(int[] nums) {
        int i = 0;
        int j = 0;

        while (i < nums.length - 1 && j < nums.length) {
            if (nums[i] == 0) {
                while (j < nums.length - 1 && nums[j] == 0) {
                    j++;
                }
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
            i++;
            if (i > j) {
                j = i;
            }
        }
    }
}
