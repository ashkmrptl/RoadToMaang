package scaler.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem Description
 * Given an array of integers A, of size N.
 * Return the maximum size subarray of A having only non-negative elements. If there are more than one such subarray,
 * return the one having the smallest starting index in A.
 * NOTE: It is guaranteed that an answer always exists.
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * -109 <= A[i] <= 109
 * <p>
 * Input Format
 * The first and only argument given is the integer array A.
 * <p>
 * Output Format
 * Return maximum size subarray of A having only non-negative elements. If there are more than one such subarrays,
 * return the one having earliest starting index in A.
 * <p>
 * Example Input
 * Input 1:
 * A = [5, 6, -1, 7, 8]
 * Input 2:
 * A = [1, 2, 3, 4, 5, 6]
 * <p>
 * Example Output
 * Output 1:
 * [5, 6]
 * Output 2:
 * [1, 2, 3, 4, 5, 6]
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * There are two subarrays of size 2 having only non-negative elements.
 * 1. [5, 6]  starting point  = 0
 * 2. [7, 8]  starting point  = 3
 * As starting point of 1 is smaller, return [5, 6]
 * Explanation 2:
 * <p>
 * There is only one subarray of size 6 having only non-negative elements:
 * [1, 2, 3, 4, 5, 6]
 */
public class MaximumPositivity {
    public static void main(String[] args) {
        int[] A = new int[]{5, 6, -1, 7, 8};
        System.out.println(Arrays.toString(solve(A)));
        System.out.println(Arrays.toString(optimizedApproach(A)));

        A = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(solve(A)));
        System.out.println(Arrays.toString(optimizedApproach(A)));
    }

    private static int[] optimizedApproach (final int[] A) {
        int i = 0, j = 0, start = -1, end = -1, n = A.length;

        while (i < n && j < n) {
            if (A[j] < 0) {
                if ((j - i) > ((end - start) + 1)) {
                    start = i;
                    end = j - 1;
                }
                i = j + 1;
            }
            j++;
        }

        if (start == -1 && end == -1) {
            return A;
        }
        int[] result = new int[(end - start) + 1];

        for (int k = start, l = 0; k <= end; k++, l++) {
            result[l] = A[k];
        }
        return result;
    }

    private static int[] solve(final int[] A) {

        int maxLength = 0;
        int start = -1, end = -1;

        for (int i = 0; i < A.length; i++) {
            if (A[i] < 0) {
                // count non -ve integers to left till start or another -ve is found
                int leftStart = -1;
                for (int j = i - 1; j >= 0; j--) {
                    if (A[j] < 0) {
                        break;
                    }
                    leftStart = j;
                }

                // count non -ve integers to right till end or another -ve is found
                int rightEnd = -1;
                for (int j = i + 1; j < A.length; j++) {
                    if (A[j] < 0) {
                        break;
                    }
                    rightEnd = j;
                }

                int leftLength = 0;
                if (leftStart != -1) {
                    leftLength = ((i - 1) - leftStart) + 1;
                }

                int rightLength = 0;
                if (rightEnd != -1) {
                    rightLength = (rightEnd - (i + 1)) + 1;
                }

                if (leftLength >= rightLength) {
                    if (maxLength < leftLength) {
                        maxLength = leftLength;
                        start = leftStart;
                        end = i - 1;
                    }
                } else {
                    if (maxLength < rightLength) {
                        maxLength = leftLength;
                        start = i + 1;
                        end = rightEnd;
                    }
                }
            }
        }
        if (start == -1 && end == -1) {
            return A;
        }
        int[] result = new int[(end - start) + 1];

        for (int i = start, j = 0; i <= end; i++, j++) {
            result[j] = A[i];
        }
        return result;
    }
}
