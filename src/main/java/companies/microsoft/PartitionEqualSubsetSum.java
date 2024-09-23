package companies.microsoft;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        System.out.println(canPartition(nums));

        nums = new int[]{1, 2, 3, 5};
        System.out.println(canPartition(nums));

        nums = new int[]{3, 3, 3, 4, 5};
        System.out.println(canPartition(nums));

        nums = new int[]{2, 2, 1, 1};
        System.out.println(canPartition(nums));
    }

    private static boolean canPartition(int[] nums) {
        int totalSum = 0;

        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        if (totalSum % 2 != 0) {
            return false;
        }

        int target = totalSum / 2;

        Boolean[][] dp = new Boolean[nums.length][target + 1];

        return backTrack(0, nums, target, dp);
    }

    private static boolean backTrack(int index, int[] nums, int target, Boolean[][] dp) {
        if (index >= nums.length) {
            return false;
        }
        if (target < 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }

        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean inclusive = backTrack(index + 1, nums, target - nums[index], dp);
        boolean exclusive = backTrack(index + 1, nums, target, dp);

        return dp[index][target] = inclusive || exclusive;
    }
}
