package companies.walmart;

/**
 * 162. Find Peak Element
 * https://leetcode.com/problems/find-peak-element/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(findPeakElement(nums));

        nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(nums));
    }

    private static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
