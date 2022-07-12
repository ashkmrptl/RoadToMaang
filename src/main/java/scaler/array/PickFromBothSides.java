package scaler.array;

import java.util.Arrays;

/**
 * ou are given an integer array A of size N.
 * <p>
 * You have to pick B elements in total. Some (possibly 0) elements from left end of array A and some (possibly 0) from
 * the right end of array A to get the maximum sum.
 * <p>
 * Find and return this maximum possible sum.
 * <p>
 * NOTE: Suppose B = 4, and array A contains 10 elements, then
 * <p>
 * You can pick the first four elements or can pick the last four elements, or can pick 1 from front and 3 from the back,
 * etc.
 * You need to return the maximum possible sum of elements you can pick.
 * <p>
 * Example :
 * <p>
 * Input 1:
 * A = [5, -2, 3 , 1, 2]
 * B = 3
 * <p>
 * Input 2:
 * A = [1, 2]
 * B = 1
 * <p>
 * Output 1:
 * 8 (Because 5 + 2 + 1)
 * <p>
 * Output 2:
 * 2 (Because 2)
 */
public class PickFromBothSides {
    public static void main(String[] args) {
        int b = 3;
        final int[] array = new int[]{5, -2, 3, 1, 2};
        System.out.printf("Maximum sum using prefix sum array = %s", findMaximumSumUsingPrefixSumArray(array, b));
        System.out.println();
        System.out.printf("Maximum sum without using prefix sum array = %s", findMaxSumWithoutUsingPrefixSumArray(array, b));
        System.out.println();

        b = 48;
        final int[] array2 = new int[]
                {-533, -666, -500, 169, 724, 478, 358, -38, -536, 705, -855, 281, -173, 961, -509,
                        -5, 942, -173, 436, -609, -396, 902, -847, -708, -618, 421, -284, 718, 895, 447,
                        726, -229, 538, 869, 912, 667, -701, 35, 894, -297, 811, 322, -667, 673, -336,
                        141, 711, -747, -132, 547, 644, -338, -243, -963, -141, -277, 741, 529, -222, -684,
                        35};
        System.out.printf("Maximum sum using prefix sum array = %s", findMaximumSumUsingPrefixSumArray(array2, b));
        System.out.println();
        System.out.printf("Maximum sum without using prefix sum array = %s", findMaxSumWithoutUsingPrefixSumArray(array2, b));
    }

    private static int findMaxSumWithoutUsingPrefixSumArray(final int[] array, final int b) {
        final int n = array.length;
        int currentSum = 0;
        for (int i = 0; i < b; i++) {
            currentSum += array[i];
        }

        int maxSum = currentSum;
        int back = b - 1;
        int end = n - 1;
        for (int i = 0; i < b; i++) {
            currentSum = currentSum - array[back] + array[end];
            back--;
            end--;
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    private static int findMaximumSumUsingPrefixSumArray(final int[] array, final int b) {
        final int n = array.length;
        int maxSum = Integer.MIN_VALUE;
        final int[] pf = new int[n];

        pf[0] = array[0];

        for (int i = 1; i < n; i++) {
            pf[i] = pf[i - 1] + array[i];
        }

        //System.out.println("prefix sum array : " + Arrays.toString(pf));

        for (int i = 0; i <= b; i++) {
            int leftIndex = b - (i + 1);
            int rightStartIndex = n - 1 - i;
            int leftSum = leftIndex < 0 ? 0 : pf[leftIndex];
            int rightSum = pf[n - 1] - (rightStartIndex < 0 ? 0 : pf[rightStartIndex]);
            int tempSum = leftSum + rightSum;
            maxSum = Math.max(tempSum, maxSum);
        }

        return maxSum;
    }
}
