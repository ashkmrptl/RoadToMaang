package companies.walmart;

import java.util.Arrays;

/**
 * 518. Coin Change II
 * https://leetcode.com/problems/coin-change-ii/description/?envType=company&envId=walmart-labs&favoriteSlug=walmart-labs-all
 */
public class CoinChangeII {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(change(5, coins));
    }

    private static int change(int amount, int[] coins) {
        // Memoization table initialized to -1 to signify uncomputed values
        int[][] dp = new int[coins.length][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return coinChangeRecursive(coins, amount, 0, dp);
    }


    private static int coinChangeRecursive(int[] coins, int amount, int index, int[][] dp) {
        // Base case: if amount is 0, we found a valid way
        if (amount == 0) return 1;
        // If amount is negative or no coins are left, there's no valid combination
        if (amount < 0 || index >= coins.length) return 0;

        // Check if this sub-problem has already been computed
        if (dp[index][amount] != -1) return dp[index][amount];

        // Option 1: Include the current coin (stay at index, reduce amount)
        int includeCoin = coinChangeRecursive(coins, amount - coins[index], index, dp);

        // Option 2: Exclude the current coin (move to next index)
        int excludeCoin = coinChangeRecursive(coins, amount, index + 1, dp);

        // Memoize the result
        dp[index][amount] = includeCoin + excludeCoin;
        return dp[index][amount];
    }
}
