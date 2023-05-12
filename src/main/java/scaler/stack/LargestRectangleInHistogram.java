package scaler.stack;

import java.util.Stack;

/**
 * Given an array of integers A.
 * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
 * Find the area of the largest rectangle formed by the histogram.
 */
public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] A = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println(solve(A));

        A = new int[]{1, 2, 3};
        System.out.println(solve(A));
    }

    private static int solve(final int[] A) {
        int n = A.length;
        int[] leftNearestSmall = new int[n];
        int[] rightNearestSmall = new int[n];

        for (int i = 0; i < n; i++) {
            leftNearestSmall[i] = -1;
            rightNearestSmall[i] = n;
        }

        final Stack<Integer> stackLeft = new Stack<>();
        final Stack<Integer> stackRight = new Stack<>();
        for (int i = 0, j = n - 1; i < n && j >= 0; i++, j--) {
            while (!stackLeft.isEmpty() && A[i] <= A[stackLeft.peek()]) {
                stackLeft.pop();
            }
            if (!stackLeft.isEmpty()) {
                leftNearestSmall[i] = stackLeft.peek();
            }
            stackLeft.push(i);

            while (!stackRight.isEmpty() && A[j] <= A[stackRight.peek()]) {
                stackRight.pop();
            }
            if (!stackRight.isEmpty()) {
                rightNearestSmall[j] = stackRight.peek();
            }
            stackRight.push(j);
        }

        int ans = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int leftSmall = leftNearestSmall[i];
            int rightSmall = rightNearestSmall[i];

            int length = rightSmall - leftSmall - 1;// the length is from leftSmall + 1 to rightSmall - 1. (rightSmall - 1) - (leftSmall + 1) + 1 => rs - 1 - ls - 1 + 1 => rs - ls - 1;
            ans = Math.max(ans, length * A[i]);
        }

        return ans;
    }
}
