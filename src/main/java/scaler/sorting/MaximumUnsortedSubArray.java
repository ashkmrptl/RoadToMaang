package scaler.sorting;

import java.util.Arrays;

public class MaximumUnsortedSubArray {
    public static void main(String[] args) {
        int[] A = new int[]{1, 1, 2, 3, 3, 4, 8, 9, 11, 9, 11, 12, 12, 11, 9, 14, 19, 20, 20};
        System.out.println(Arrays.toString(solve(A)));

        A = new int[]{4, 15, 4, 4, 15, 18, 20};
        System.out.println(Arrays.toString(solve(A)));
    }

    private static int[] solve(int[] A) {
        int start = 0;
        int end = A.length - 1;

        while (start < A.length - 1) {
            if (A[start] <= A[start + 1]) {
                start++;
            } else {
                break;
            }
        }

        while (end > 0) {
            if (A[end] >= A[end - 1]) {
                end--;
            } else {
                break;
            }
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            max = Math.max(max, A[i]);
            min = Math.min(min, A[i]);
        }

        for (int i = 0; i < A.length; i++) {
            if (A[i] > min) {
                start = i;
                break;
            }
        }

        for (int i = A.length - 1; i >= 0; i--) {
            if (A[i] < max) {
                end = i;
                break;
            }
        }

        if (start >= end) {
            return new int[]{-1};
        } else {
            return new int[]{start, end};
        }
    }
}
