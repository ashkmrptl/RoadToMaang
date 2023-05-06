package companies.walmart;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));

        nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(rob(nums));

        nums = new int[]{2, 1, 1, 2};
        System.out.println(rob(nums));
    }

    //DP/Memoization
    private static int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        final int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i], dp[i - 1] + nums[i]);
        }

        return dp[nums.length];
    }

    //Bruteforce approach
    private static int rob_brute_force(int[] nums) {
        return Math.max(bfRecur(nums, 0), bfRecur(nums, 1));
    }

    private static int bfRecur(int[] nums, int i) {
        if (i > nums.length - 1) {
            return 0;
        }

        int left = bfRecur(nums, i + 2);
        int right = bfRecur(nums, i + 3);

        return nums[i] + Math.max(left, right);
    }
}
