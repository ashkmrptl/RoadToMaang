package companies.walmart;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. Contiguous Array
 * https://leetcode.com/problems/contiguous-array/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = new int[] {0, 1};
        System.out.println(findMaxLength(nums));

        nums = new int[] {0, 1, 0};
        System.out.println(findMaxLength(nums));

        nums = new int[] {0,0,1,0,0,0,1,1};
        System.out.println(findMaxLength(nums));
    }

    private static int findMaxLength(int[] nums) {

        // Map to store sum and index
        final Map<Integer, Integer> map = new HashMap<>();

        int maxLength = 0;

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

            if (num == 0) {
                sum = sum - 1;
            } else {
                sum = sum + 1;
            }

            if (sum == 0) {
                maxLength = Math.max(maxLength, i + 1);
                continue;
            }

            if (map.containsKey(sum)) {
                maxLength = Math.max(maxLength, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
