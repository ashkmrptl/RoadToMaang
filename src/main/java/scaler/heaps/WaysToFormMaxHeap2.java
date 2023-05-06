package scaler.heaps;

import java.util.Arrays;
import java.util.Objects;

//Copied. Need to practice it
public class WaysToFormMaxHeap2 {
    final int MOD = 1000 * 1000 * 1000 + 7;
    final int MAX = 1005;
    long[] dp = new long[MAX];
    long[] dp2 = new long[MAX];
    int[] log = new int[MAX];
    long[][] nCk = new long[MAX][MAX];

    public int solve(int[] A) {

        Arrays.fill(dp2, -1);
        Arrays.fill(dp, -1);
        Arrays.fill(log, -1);
        for (long[] row : nCk)
            Arrays.fill(row, -1);

        int n = A.length;
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;

        Arrays.sort(A);
        boolean minRepeating = Objects.equals(A[0], A[1]);

        if (minRepeating) {
            return (int) ((numberOfWays2(n) + MOD) % MOD);
        }

        return (int) ((numberOfWays(n) + MOD) % MOD);
    }

    long numberOfWays2(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1;
        if (dp2[n] != -1) return dp2[n];
        int height = log2(n);
        int nodes = (1 << height) - 1;

        int left = ((nodes - 1) / 2) + Math.min(n - nodes, (nodes + 1) / 2);
        int right = n - left - 1;
        //If repeated min are in left subtree
        long ans = (compute(n - 3, left - 2) % MOD * numberOfWays2(left) % MOD * numberOfWays(right) % MOD) % MOD;
        //If repeated min are in right subtree
        ans = (ans % MOD) + (compute(n - 3, right - 2) % MOD * numberOfWays(left) % MOD * numberOfWays2(right) % MOD) % MOD;
        //If 1 is in left & other is in right subtree
        ans = (ans % MOD) + (compute(n - 3, left - 1) % MOD * numberOfWays(left) % MOD * numberOfWays(right) % MOD) % MOD;

        dp2[n] = ans;

        return dp2[n];

    }

    long numberOfWays(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (dp[n] != -1) return dp[n];

        int height = log2(n);
        int nodes = (1 << height) - 1;

        int left = ((nodes - 1) / 2) + Math.min(n - nodes, (nodes + 1) / 2);
        int right = n - left - 1;
        dp[n] = (compute(n - 1, left) % MOD * numberOfWays(left) % MOD * numberOfWays(right) % MOD) % MOD;
        return dp[n];
    }


    long compute(int n, int k) {
        if (k < 0 || k > n) {
            return 0;
        }
        if (n <= 1 || k == 0) {
            return 1;
        }

        if (nCk[n][k] != -1) {
            return nCk[n][k];
        }

        long answer = (compute(n - 1, k - 1) + compute(n - 1, k)) % MOD;
        nCk[n][k] = answer;
        return answer;
    }

    int log2(int n) {
        if (log[n] != -1) {
            return log[n];
        }
        return (int) (Math.log(n) / Math.log(2) + 1e-10);
    }
}
