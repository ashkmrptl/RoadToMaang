package companies.walmart;

import java.util.Arrays;

/**
 * 179. Largest Number
 * <p>
 * https://leetcode.com/problems/largest-number/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
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
        final String[] numberString = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numberString[i] = Integer.toString(nums[i]);
        }

        Arrays.sort(numberString, (a, b) -> (b + a).compareTo(a + b));

        if (numberString[0].equals("0")) {
            return "0";
        }

        final StringBuilder sb = new StringBuilder();
        for (String num : numberString) {
            sb.append(num);
        }

        return sb.toString();
    }
}
