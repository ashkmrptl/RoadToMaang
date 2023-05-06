package companies.intuit;

import java.util.*;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * You can return the answer in any order.
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum(nums, 9)));

        nums = new int[]{3, 2, 4};

        System.out.println(Arrays.toString(twoSum(nums, 6)));

        nums = new int[]{3, 3};

        System.out.println(Arrays.toString(twoSum(nums, 6)));
    }

    private static int[] twoSum(int[] nums, int target) {
        final Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return new int[]{};
    }
}
