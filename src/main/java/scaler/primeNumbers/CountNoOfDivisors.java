package scaler.primeNumbers;

import java.util.Arrays;

public class CountNoOfDivisors {
    public static void main(String[] args) {
        int[] A = new int[]{2, 3, 4, 5, 50};
        System.out.println(Arrays.toString(solve(A)));

        A = new int[]{8, 9, 10};
        System.out.println(Arrays.toString(solve(A)));
    }

    /**
     * In this approach we use the smallest prime factor.
     */
    private static int[] solveOptimized(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }

        int[] spf = new int[A.length + 1];
        for (int i = 0; i < spf.length; i++) {
            spf[i] = i;
        }

        for (int i = 0; i < spf.length; i++) {

        }

        return new int[2];
    }

    private static int[] solve(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
        }

        int[] spf = new int[max + 1];

        for (int i = 1; i < spf.length; i++) {
            for (int j = i; j < spf.length; j += i) {
                spf[j] = spf[j] + 1;
            }
        }
        int[] result = new int[A.length];

        for (int i = 0; i < A.length; i++) {
            result[i] = spf[A[i]];
        }

        return result;
    }
}
