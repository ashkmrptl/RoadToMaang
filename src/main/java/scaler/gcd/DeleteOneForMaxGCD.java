package scaler.gcd;

/**
 * Given an integer array A of size N. You have to delete one element such that the GCD(Greatest common divisor) of the remaining array is maximum.
 * <p>
 * Find the maximum value of GCD.
 */
public class DeleteOneForMaxGCD {
    public static void main(String[] args) {
        int[] A = new int[]{3, 9, 6, 8, 3};
        System.out.println(solve(A));
    }

    private static int solve(int[] A) {
        int n = A.length;
        int[] sfGCDArray = new int[n];
        sfGCDArray[n - 1] = A[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            sfGCDArray[i] = calculateGCD(Math.min(sfGCDArray[i + 1], A[i]), Math.max(sfGCDArray[i + 1], A[i]));
        }

        int maxGCD = Integer.MIN_VALUE;
        int leftGCD = 0;

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                leftGCD = calculateGCD(Math.min(leftGCD, A[i - 1]), Math.max(leftGCD, A[i - 1]));
            }

            int rightGCD = 0;
            if (i < n - 1) {
                rightGCD = sfGCDArray[i + 1];
            }

            int gcd = calculateGCD(Math.min(leftGCD, rightGCD), Math.max(leftGCD, rightGCD));

            maxGCD = Math.max(maxGCD, gcd);
        }

        return maxGCD;
    }

    private static int calculateGCD(int a, int b) {
        while (a > 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }

        return b;
    }
}
