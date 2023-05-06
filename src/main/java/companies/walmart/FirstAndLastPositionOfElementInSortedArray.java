package companies.walmart;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    private static int[] searchRange(int[] nums, int target) {
        final int[] ans = new int[] {-1, -1};
        binarySearch(nums, 0, nums.length - 1, target, ans);

        return ans;
    }

    private static void binarySearch(int[] nums, int start, int end, int target, int[] ans) {
        if (start > end) {
            return;
        }

        int mid = (start + end) / 2;

        if (target == nums[mid]) {
            //TODO: scan both direction (take care of boundary condition)
            if (ans[0] == -1 & ans[1] == -1) {
                ans[0] = ans[1] = mid;
            } else {
                if (mid < ans[0]) {
                    ans[0] = mid;
                } else if (mid > ans[1]) {
                    ans[1] = mid;
                }
            }

            binarySearch(nums, start, mid - 1, target, ans);
            binarySearch(nums, mid + 1, end, target, ans);

        } else if (target < nums[mid]) {
            binarySearch(nums, start, mid - 1, target, ans);
        } else {
            binarySearch(nums, mid + 1, end, target, ans);
        }
    }
}
