package scaler.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of size N and Q queries of the format start(s) and end(e). Return the sum of the elements from s to e for each query.
 */
public class RangeQSumArray {
    public static void main_old(String[] args) {
        final int[] A = new int[]{-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};
        final Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 3);
        map.put(2, 7);
        map.put(4, 8);
        map.put(0, 2);

        final int[] PF = getPrefixSumArray(A);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            printRangeSum(PF, entry.getKey(), entry.getValue());
            printRangeSumWithConstantSpace(A, entry.getKey(), entry.getValue());
        }
    }

    public static void main(String[] args) {
        final int[] A = new int[]{7, 3, 1, 5, 5, 5, 1, 2, 4, 5};
        final int[][] B = new int[][]{{7, 10}, {3, 10}, {3, 5}, {1, 10}};

        System.out.println(Arrays.toString(rangeSum(A, B)));
    }

    public static long[] rangeSum(int[] A, int[][] B) {
        final long[] array = new long[B.length];

        final long[] prefixSumArray = new long[A.length];
        prefixSumArray[0] = A[0];

        for (int i = 1; i < A.length; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + A[i];
        }

        for (int i = 0; i < B.length; i++) {
            final int[] temp = B[i];
            final int start = temp[0] - 1;
            final int end = temp[1] - 1;

            array[i] = printRangeSumLong(prefixSumArray, start, end);
        }

        return array;
    }

    /**
     * This approach requires O(1) space but takes O(q * n) Time complexity.
     * <p>
     * Instead of calculating the PF Sum array beforehand, we are calculating it for all the ranges on the fly
     */
    private static void printRangeSumWithConstantSpace(final int[] array, final int start, final int end) {

        int pfSumStart = 0;
        int pfSumEnd = 0;

        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                pfSumStart = array[i];
                pfSumEnd = array[i];
                continue;
            }
            if (i < start) {
                pfSumStart = pfSumStart + array[i];
            }

            if (i <= end) {
                pfSumEnd = pfSumEnd + array[i];
            } else {
                break;
            }
        }
        final int sum = start == 0 ? pfSumEnd : (pfSumEnd - pfSumStart);
        System.out.printf("Sum of elements from %s to %s = %s%n", start, end, sum);

    }

    /**
     * This approach has TC O(n + q) or O(MAX(n, q)) and SC O(n)
     */
    private static void printRangeSum(final int[] PF, final int start, final int end) {
        final int sum;

        if (start == 0) {
            sum = PF[end];
        } else {
            sum = PF[end] - PF[start - 1];
        }

        System.out.printf("Sum of elements from %s to %s = %s%n", start, end, sum);
    }

    private static long printRangeSumLong(final long[] PF, final int start, final int end) {
        final long sum;

        if (start == 0) {
            sum = PF[end];
        } else {
            sum = PF[end] - PF[start - 1];
        }

        return sum;
    }

    private static int[] getPrefixSumArray(final int[] array) {
        final int[] pf = new int[array.length];
        pf[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            pf[i] = pf[i - 1] + array[i];
        }

        return pf;
    }
}
