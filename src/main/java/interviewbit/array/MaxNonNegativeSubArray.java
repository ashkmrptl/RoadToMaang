package interviewbit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of integers, A of length N, find out the maximum sum sub-array of non negative numbers from A.
 * <p>
 * The sub-array should be contiguous i.e., a sub-array created by choosing the second and fourth element and skipping the third element is invalid.
 * <p>
 * Maximum sub-array is defined in terms of the sum of the elements in the sub-array.
 * <p>
 * Find and return the required sub-array.
 * <p>
 * NOTE:
 * <p>
 * If there is a tie, then compare with segment's length and return segment which has maximum length.
 * If there is still a tie, then return the segment with minimum starting index.
 */
public class MaxNonNegativeSubArray {
    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 2, 5, -7, -8, 1, 1, 1, 3, 4};

        System.out.println("sub-array length with max sum : " + findLength(A));
        System.out.println("sub-array with max sum : " + Arrays.toString(findSubArrayWithMaxSum(A)));
        System.out.println("max sub-array sum having non-negative integers : " + maxSumOfSubArray(A));
    }

    private static int[] findSubArrayWithMaxSum(final int[] A) {
        int n = A.length;
        long maxSum = Integer.MIN_VALUE;
        int maxLength = 0;
        List<Integer> maxSubArray = new ArrayList<>();

        long currentSum = 0;
        int currentLength = 0;
        List<Integer> currentSubArray = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                currentSum = 0;
                currentLength = 0;
                currentSubArray = new ArrayList<>();
            } else {
                currentLength++;
                currentSum += A[i];
                currentSubArray.add(A[i]);
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                maxSubArray = currentSubArray;
            } else if (currentSum == maxSum && currentLength > maxLength) {
                maxSubArray = currentSubArray;
            }

            maxLength = Math.max(currentLength, maxLength);
        }

        int j = 0;
        int[] result = new int[maxSubArray.size()];
        for (int num : maxSubArray) {
            result[j] = num;
            j++;
        }

        return result;
    }

    /**
     * This calculates the max sum of sub array having non-negative integers
     */
    private static int maxSumOfSubArray(final int[] A) {
        int maxSum = Integer.MIN_VALUE;

        int i = 0;
        int n = A.length;
        int currentSum = 0;

        while (i < n) {
            if (A[i] < 0) {
                currentSum = 0;
            } else {
                currentSum += A[i];
            }
            i++;
            maxSum = Math.max(currentSum, maxSum);
        }
        return maxSum;
    }

    private static int findLength(final int[] A) {
        int n = A.length;
        int maxLength = Integer.MIN_VALUE;

        int i = 0;
        int count = 0;

        while (i < n) {
            if (A[i] < 0) {
                count = 0;
            } else {
                count++;
            }
            i++;
            maxLength = Math.max(maxLength, count);
        }

        return maxLength;
    }
}
