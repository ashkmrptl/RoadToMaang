package companies.walmart;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int[] nums = new int[] {2, 0, 2, 1, 1, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[] {1, 2, 0};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void sortColors(int[] nums) {
        int zeroCount = 0;
        int oneCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            } else if (nums[i] == 1) {
                oneCount++;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (zeroCount != 0) {
                zeroCount--;
                nums[i] = 0;
            } else if (oneCount != 0) {
                oneCount--;
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
