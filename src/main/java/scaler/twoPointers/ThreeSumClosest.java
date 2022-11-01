package scaler.twoPointers;

import java.util.Arrays;

/**
 * Given an array A of N integers, find three integers in A such that the sum is closest to a given number B. Return the sum of those three integers.
 * Assume that there will only be one solution.
 * Return a single integer denoting the sum of three integers which is closest to B.
 */
public class ThreeSumClosest {
    public static void main(String[] args) {
        int[] A = new int[]{-5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3};
        int B = -1;
        System.out.println(solve(A, B));

        A = new int[]{-1, 2, 1, 4};
        B = 1;
        System.out.println(solve(A, B));

        A = new int[]{1, 2, 3};
        B = 6;
        System.out.println(solve(A, B));
    }

    /**
     * closest sum: it means Math.abs(sum - B) is minimum
     */
    private static int solve(int[] A, int B) {
        int n = A.length;

        // Sort the array
        Arrays.sort(A);

        // Initialize result
        int result = A[0] + A[1] + A[2];

        // Consider all possible triplets and update the result if needed
        for (int i = 0; i < n - 2; i++) {
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = A[i] + A[j] + A[k];

                // If sum is more close to the given number
                if (Math.abs(B - sum) < Math.abs(B - result))
                    result = sum;

                if (sum > B) {// If sum is greater, decrease the value of k
                    k--;
                } else {// If sum is smaller, increase the value of j
                    j++;
                }
            }
        }
        return result;
    }
}
