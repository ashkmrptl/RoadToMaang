package scaler.twoPointers;

import java.util.Arrays;

/**
 * Given two sorted arrays of distinct integers, A and B, and an integer C, find and return the pair whose sum is closest to C and the pair has one element from each array.
 * <p>
 * More formally, find A[i] and B[j] such that abs((A[i] + B[j]) - C) has minimum value.
 * <p>
 * If there are multiple solutions find the one with minimum i and even if there are multiple values of j for the same i then return the one with minimum j.
 * <p>
 * Return an array with two elements {A[i], B[j]}.
 */
public class ClosestPairFromSortedArrays {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] B = new int[]{2, 4, 6, 8};
        int C = 9;

        System.out.println(Arrays.toString(solve(A, B, C)));

        A = new int[]{1};
        B = new int[]{2, 4};
        C = 4;
        System.out.println(Arrays.toString(solve(A, B, C)));
    }

    private static int[] solve(int[] A, int[] B, int C) {
        int left = 0;
        int right = B.length - 1;

        int min = Integer.MAX_VALUE;

        int res_left = A.length;
        int res_right = B.length;

        while (left < A.length && right >= 0) {
            int sum = A[left] + B[right];
            int diff = Math.abs((sum - C));

            if (diff <= min) {
                if (left < res_left || diff < min) {
                    res_left = left;
                }
                if ((right < res_right && left == res_left) || diff < min) {
                    res_right = right;
                }
                min = diff;
            }

            if (sum > C) {
                right--;
            } else if (sum < C) {
                left++;
            } else {
                left++;
                right--;
            }

        }
        return new int[]{A[res_left], B[res_right]};
    }
}
