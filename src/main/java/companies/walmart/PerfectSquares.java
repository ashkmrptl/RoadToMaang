package companies.walmart;

import java.util.Arrays;

/**
 * 279. Perfect Squares
 * https://leetcode.com/problems/perfect-squares/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class PerfectSquares {
    public static void main(String[] args) {
        System.out.println(numSquare(12));
        System.out.println(numSquare(13));
    }

    private static int numSquare(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        return recurse(n, dp);
    }

    private static int recurse(int n, int[] dp) {
        if (n <= 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, recurse(n - (i * i), dp) + 1);
        }

        return dp[n] = min;
    }
}
