package companies.visa;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers. The degree of this array is defined as the maximum frequency of any
 * one of its elements. The task is to find the smallest possible length of a sub-array that has the same degree as array.
 */
public class DegreeOfAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }

    private static int findShortestSubArray(int[] nums) {
        int maxFrequency = Integer.MIN_VALUE;

        final Map<Integer, Integer> frequency = new HashMap<>();
        for (int num : nums) {
            if (frequency.containsKey(num)) {
                frequency.put(num, frequency.get(num) + 1);
            } else {
                frequency.put(num, 1);
            }

            maxFrequency = Math.max(maxFrequency, frequency.get(num));
        }

        int ans = Integer.MAX_VALUE;
        int start;
        int end;

        for (final Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            start = -1;
            end = -1;
            if (entry.getValue() == maxFrequency) {
                for (int i = 0; i < nums.length; i++) {
                    if (start == -1 && nums[i] == entry.getKey()) {
                        start = i;
                    }
                    if (nums[i] == entry.getKey()) {
                        end = i;
                    }
                }

                ans = Math.min(ans, end - start + 1);
            }
        }

        return ans;
    }
}
