package companies.walmart;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 2461. Maximum Sum of Distinct Sub-arrays With Length K
 * https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class MaximumSumOfDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        int k = 3;
        int[] nums = new int[]{1, 5, 4, 2, 9, 9, 9};

        System.out.println(maximumSubarraySum(nums, k));

        k = 3;
        nums = new int[]{9, 9, 9, 1, 2, 3};

        System.out.println(maximumSubarraySum(nums, k));
    }

    private static long maximumSubarraySum(int[] nums, int k) {
        if (nums.length < k) {
            return 0L;
        }

        //First window
        final Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        int j = 0;
        long currSum = 0L;
        while (j < nums.length && j - i < k) {
            currSum += nums[j];
            addToMap(map, nums[j]);
            j++;
        }

        long maxSum = 0L;
        if (map.size() == k) {
            maxSum = currSum;
        }

        while (j < nums.length) {
            int numToAdd = nums[j];
            int numToRemove = nums[i];

            addToMap(map, numToAdd);
            removeFromMap(map, numToRemove);

            currSum = currSum - numToRemove + numToAdd;
            j++;
            i++;

            if (map.size() == k) {
                maxSum = Math.max(currSum, maxSum);
            }
        }

        return maxSum;
    }

    private static void addToMap(final Map<Integer, Integer> map, int toAdd) {
        if (map.containsKey(toAdd)) {
            map.put(toAdd, map.get(toAdd) + 1);
        } else {
            map.put(toAdd, 1);
        }
    }

    private static void removeFromMap(final Map<Integer, Integer> map, int toRemove) {
        if (map.containsKey(toRemove)) {
            map.put(toRemove, map.get(toRemove) - 1);

            if (map.get(toRemove) == 0) {
                map.remove(toRemove);
            }
        }
    }
}
