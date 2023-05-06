package companies.walmart;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 */
public class ClimbingStairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));

        System.out.println(climbStairs(3));
    }

    private static int climbStairs(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 2; i < n; i++) {
            dp[i + 1] = dp[i] + dp[i - 1];
        }

        return dp[n];
    }
}
