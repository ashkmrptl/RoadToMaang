package companies.walmart;

import java.util.HashMap;
import java.util.Map;

/**
 * 1248. Count Number of Nice Subarrays
 * https://leetcode.com/problems/count-number-of-nice-subarrays/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class CountNumberOfNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2, 1, 1};
        System.out.println(numberOfSubarrays_usingHash(nums, 3));
        System.out.println(numberOfSubarrays_withConstantSpace(nums, 3));

        nums = new int[]{2, 4, 6};
        System.out.println(numberOfSubarrays_usingHash(nums, 1));
        System.out.println(numberOfSubarrays_withConstantSpace(nums, 1));

        nums = new int[]{2, 2, 2, 1, 2, 2, 1, 2, 2, 2};
        System.out.println(numberOfSubarrays_usingHash(nums, 2));
        System.out.println(numberOfSubarrays_withConstantSpace(nums, 2));
    }

    private static int numberOfSubarrays_usingHash(int[] nums, int k) {
        int count = 0;
        int oddCount = 0;

        //(prefixSum, count)
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);//There is one subarray with no odd numbers in it

        for (final int num : nums) {
            oddCount += num % 2;
            int rem = oddCount - k;

            if (map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(oddCount, map.getOrDefault(oddCount, 0) + 1);
        }

        return count;
    }

    private static int numberOfSubarrays_withConstantSpace(int[] nums, int k) {
        return count(nums, k) - count(nums, k - 1);
    }

    private static int count(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        int l = 0;
        int r = 0;

        int count = 0;
        int countOdd = 0;

        while (r < nums.length) {
            countOdd += nums[r] % 2;

            while (countOdd > k) {
                countOdd -= nums[l] % 2;
                l++;
            }

            count += (r - l + 1);
            r++;
        }

        return count;
    }
}
