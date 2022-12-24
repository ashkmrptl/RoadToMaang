package scaler.dynamicProgramming;

import java.util.Arrays;

/**
 * Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 * Ex: For 6 ans is 3.
 * <p>
 * Possible combinations are : (1^2 + 1^2 + 1^2 + 1^2 + 1^2 + 1^2) and (1^2 + 1^2 + 2^2).
 * Minimum count of numbers, sum of whose squares is 6 is 3.
 */
public class MinimumNoOfSquares {
    public static void main(String[] args) {
        System.out.println(countMinSquares(5));
        System.out.println(countMinSquares(6));
    }

    private static int countMinSquares(int A) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, -1);

        return recursive(A, dp);
    }

    private static int recursive(int A, int[] dp) {
        if (A == 0) {
            return 0;
        }

        //Check dp array
        if (dp[A] != -1) {
            return dp[A];
        }

        int ans = recursive(A - 1, dp);

        for (int i = 2; i * i <= A; i++) {
            ans = Math.min(ans, recursive(A - (i * i), dp));
        }

        dp[A] = ans + 1;

        return dp[A];
    }
}
