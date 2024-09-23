package companies.visa;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));

        nums = new int[]{0, 1, 1};
        System.out.println(threeSum(nums));

        nums = new int[]{0, 0, 0};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        final List<List<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                final List<List<Integer>> ans = twoSum(nums, i + 1, nums.length - 1, 0 - nums[i]);
                if (!ans.isEmpty()) {
                    answer.addAll(ans);
                }
            }
        }


        return answer;
    }

    private static List<List<Integer>> twoSum(int[] nums, int start, int end, int target) {
        final List<List<Integer>> ans = new ArrayList<>();

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                start++;
            } else {
                final List<Integer> list = new ArrayList<>();
                list.add(0 - target);
                list.add(nums[start]);
                list.add(nums[end]);

                ans.add(list);

                start++;
                end--;

                //Skipping equal elements
                while (start < end && nums[start] == nums[start - 1]) {
                    start++;
                }
                while (start < end && nums[end] == nums[end + 1]) {
                    end--;
                }
            }
        }

        return ans;
    }
}
