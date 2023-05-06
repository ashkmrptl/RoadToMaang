package companies.intuit;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicateOptimized(nums));

        nums = new int[]{3, 1, 3, 4, 2};
        System.out.println(findDuplicateOptimized(nums));

        nums = new int[]{2, 2, 2, 2, 2};
        System.out.println(findDuplicateOptimized(nums));
    }

    /**
     * This is linked list cycle detection and find the cycle approach.
     * We take two pointers(slow and fast). Move them to find the cycle.
     * Then we start fast from start again and move both one element per step, the place where they meet is the duplicate
     *
     * *Note: Prepare the proof of this concept(in case interviewer ask to explain)
     */
    private static int findDuplicateOptimized(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        fast = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }

    /**
     * Below approach has TC od O(n) and SC O(n)
     */
    private static int findDuplicate(int[] nums) {
        final Set<Integer> set = new HashSet<>();
        for (final int num : nums) {
            if (set.contains(num)) {
                return num;
            } else {
                set.add(num);
            }
        }

        return -1;
    }
}
