package companies.walmart;

import java.util.Arrays;

/**
 * Given a list of non-negative integers "nums". Arrange them such that they form the largest number and return it.
 * <p>
 * Since the result may be very large, so return a string.
 * Example 1:
 * <p>
 * Input: nums = [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: nums = [3,30,34,5,9]
 * Output: "9534330"
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 30, 34, 5, 9};
        System.out.println(largestNumber(nums));

        nums = new int[]{0, 0};
        System.out.println(largestNumber(nums));

        nums = new int[]{1, 0, 0};
        System.out.println(largestNumber(nums));
    }

    private static String largestNumber(int[] nums) {
        String[] numsStr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsStr[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numsStr, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder sb = new StringBuilder();
        for (String num : numsStr) {
            sb.append(num);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}
