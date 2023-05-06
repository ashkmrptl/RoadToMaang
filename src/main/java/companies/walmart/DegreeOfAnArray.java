package companies.walmart;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * Input: nums = [1,2,2,3,1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 */
public class DegreeOfAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }

    private static int findShortestSubArray(int[] nums) {
        int maxFrequency = Integer.MIN_VALUE;

        final Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (frequencyMap.containsKey(num)) {
                frequencyMap.put(num, frequencyMap.get(num) + 1);
            } else {
                frequencyMap.put(num, 1);
            }

            maxFrequency = Math.max(maxFrequency, frequencyMap.get(num));
        }

        int ans = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
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
