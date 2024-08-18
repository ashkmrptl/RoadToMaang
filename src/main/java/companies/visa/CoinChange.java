package companies.visa;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins, 11));

        coins = new int[]{2};
        System.out.println(coinChange(coins, 3));

        coins = new int[]{1};
        System.out.println(coinChange(coins, 0));
    }


    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        //Setting first element as ZERO, because no of coins required to make amount ZERO is 0.
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
