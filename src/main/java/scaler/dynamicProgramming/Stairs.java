package scaler.dynamicProgramming;

import java.util.Arrays;

/**
 * You are climbing a staircase and it takes A steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Return the number of distinct ways modulo 1000000007
 */
public class Stairs {
    public static void main(String[] args) {
        System.out.println(climbStairs(2));
        System.out.println(climbStairs(3));
        System.out.println(climbStairs(4));
        System.out.println(climbStairs(5));
    }

    private static final int MOD = 1000 * 1000 * 1000 + 7;

    private static int climbStairs(int A) {
        int[] array = new int[A + 1];
        Arrays.fill(array, -1);

        return recursive(A, array);
    }

    private static int recursive(int A, int[] B) {
        //Base case
        if (A <= 2) {
            return A;
        }

        //Check if answer is already available in DP array
        if (B[A] != -1) {
            return B[A];
        }

        //Recursive relation is ways(n) = ways(n - 1) * 1 + ways(n - 2) * 1
        B[A] = (recursive(A - 1, B) % MOD + recursive(A - 2, B) % MOD) % MOD;
        return B[A];
    }

    private static int iterative(int A, int[] B) {
        if (A <= 2) {
            return A;
        }

        B[0] = 0;
        B[1] = 1;
        B[2] = 2;

        int a = 1;
        int b = 2;

        for (int i = 3; i < A; i++) {
            int c = a + b;
            a = b;
            b = c;

            B[i] = c;
        }

        return B[A];
    }
}
