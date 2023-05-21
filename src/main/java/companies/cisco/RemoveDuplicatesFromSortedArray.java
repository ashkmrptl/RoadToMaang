package companies.cisco;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{1, 1, 2};
        System.out.println(removeDuplicates_another_approach(nums));

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(nums));
        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates_another_approach(nums));
    }

    private static int removeDuplicates(int[] nums) {
        int index = 1;

        int i = 1;

        while (i < nums.length) {
            if (nums[i] != nums[index - 1]) {
                nums[index] = nums[i];
                index++;
            }
            i++;
        }
        return index;
    }

    private static int removeDuplicates_another_approach(int[] nums) {
        int index = 1;
        int unique = nums[0];

        for (int num : nums) {
            if (unique == num) {
                continue;
            }
            nums[index++] = num;
            unique = num;
        }

        return index;
    }
}
