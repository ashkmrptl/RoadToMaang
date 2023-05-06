package companies.appliedMaterials;

import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(fibRecursive(6));
        System.out.println(fibIterative(6));

        System.out.println(fibDP(6));
    }

    //Dynamic Programming
    private static int fibDP(int n) {
        final int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return fibDPRecursive(n, dp);
    }

    private static int fibDPRecursive(int n, int[] dp) {
        if (n <= 1) {
            dp[n] = n;
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int ans = fibDPRecursive(n - 1, dp) + fibDPRecursive(n - 2, dp);
        dp[n] = ans;

        return ans;
    }

    //Recursive
    private static int fibRecursive(int n) {
        if (n <= 1) {
            return n;
        }

        return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    //Iterative
    private static int fibIterative(int n) {
        if (n <= 1) {
            return n;
        }

        int fib = 1;
        int prevFib = 1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib += prevFib;
            prevFib = temp;
        }

        return fib;
    }
}
