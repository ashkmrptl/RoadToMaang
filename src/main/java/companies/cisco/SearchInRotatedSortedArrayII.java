package companies.cisco;

/**
 * Array contains duplicate elements
 */
public class SearchInRotatedSortedArrayII {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        System.out.println(search(nums, 0));

        nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        System.out.println(search(nums, 3));

        nums = new int[]{1, 3};
        System.out.println(search(nums, 3));

        nums = new int[]{3, 5, 1};
        System.out.println(search(nums, 3));
    }

    private static boolean search(int[] nums, int target) {
        int pivot = -1;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        int start = 0;
        int end = nums.length - 1;

        if (target < nums[start]) {
            start = pivot + 1;
        } else if (target > nums[end]) {
            end = pivot;
        }

        //Modified binary search
        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return true;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return false;
    }
}
