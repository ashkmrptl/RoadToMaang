package companies.walmart;


import java.util.Arrays;

/**
 * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
 * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
 * You may assume that you have an infinite number of each kind of coin.
 * <p>
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 * **NOTE: This problem is similar to "UNBOUNDED KNAPSACK"
 *
 * TC O(amount * N)
 * SC O(amount) -> as we are taking an array from 0 to amount
 */
public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 11));

        coins = new int[]{1, 3, 4, 5};
        System.out.println(coinChange(coins, 7));

        coins = new int[]{2};
        System.out.println(coinChange(coins, 3));
    }

    private static int coinChange(int[] coins, int amount) {
        //As we are calculating from 0 -> amount the dp array size is amount + 1
        //Also we set all elements to INFINITY(Math.MAX) or amount + 1
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                int currentAmount = i;
                int remainingAmount = currentAmount - coins[j];

                if (remainingAmount >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[remainingAmount]);
                }
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }
}
