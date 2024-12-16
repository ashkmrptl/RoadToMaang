package companies.walmart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));

        nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums));

        nums = new int[]{1, 2, 0, 1};
        System.out.println(longestConsecutive(nums));
    }

    private static int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);

        final List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (list.get(list.size() - 1) != nums[i]) {
                list.add(nums[i]);
            }
        }

        int maxLength = 0;

        int left = 0;
        int right = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) == list.get(i + 1) - 1) {
                right++;
            } else {
                maxLength = Math.max(maxLength, right - left + 1);
                left = right = i + 1;
            }
        }

        maxLength = Math.max(maxLength, right - left + 1);

        return maxLength;
    }
}
