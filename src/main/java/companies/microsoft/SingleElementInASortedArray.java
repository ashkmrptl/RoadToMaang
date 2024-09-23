package companies.microsoft;

public class SingleElementInASortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 7, 7, 10, 11, 11};
        System.out.println(singleNonDuplicate(nums));

        nums = new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(singleNonDuplicate(nums));

        nums = new int[]{1};
        System.out.println(singleNonDuplicate(nums));

        nums = new int[]{1, 1, 2};
        System.out.println(singleNonDuplicate(nums));

        nums = new int[]{1, 2, 2};
        System.out.println(singleNonDuplicate(nums));
    }

    private static int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        //Edge cases
        if (high == 0) {
            return nums[0];
        }

        //Check boundary elements
        if (nums[0] != nums[1]) {
            return nums[0];
        } else if (nums[high - 1] != nums[high]) {
            return nums[high];
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] != nums[mid + 1] && nums[mid] != nums[mid - 1]) {
                return nums[mid];
            }

            if ((mid % 2 == 0 && nums[mid] == nums[mid + 1]) || (mid % 2 != 0 && nums[mid] == nums[mid - 1])) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
