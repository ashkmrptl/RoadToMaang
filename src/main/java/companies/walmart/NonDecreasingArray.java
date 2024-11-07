package companies.walmart;

/**
 * 665. Non-decreasing Array
 * https://leetcode.com/problems/non-decreasing-array/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 3};
        System.out.println(checkPossibility(nums));

        nums = new int[]{4, 2, 1};
        System.out.println(checkPossibility(nums));

        nums = new int[]{3, 4, 2, 3};
        System.out.println(checkPossibility(nums));
    }

    private static boolean checkPossibility(int[] nums) {
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                count++;
                if (count > 1) {
                    return false;
                }

                if (i > 0 && nums[i - 1] > nums[i + 1]) {
                    nums[i + 1] = nums[i];
                } else {
                    nums[i] = nums[i + 1];
                }
            }
        }

        return true;
    }
}
