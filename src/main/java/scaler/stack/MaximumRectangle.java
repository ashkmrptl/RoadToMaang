package scaler.stack;

import java.util.Stack;

/**
 * Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
 * Find the largest rectangle containing only 1's and return its area.
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 * <p>
 * This is a follow up question on "LargestRectangleOnHistogram"
 */
public class MaximumRectangle {
    public static void main(String[] args) {
        int[][] A = new int[][]{{0, 0, 1}, {0, 1, 1}, {1, 1, 1}};
        //System.out.println(solve(A));
        //System.out.println(solve_copied_from_discussion(A));

        A = new int[][]{{0, 1, 1}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 0, 0}, {1, 1, 1}, {0, 1, 0}};
        System.out.println(solve(A));
        System.out.println(solve_copied_from_discussion(A));
    }

    private static int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        //Calculate prefix sum column wise
        int[][] PF = new int[n][m];

        //Copy first row as it is
        for (int j = 0; j < m; j++) {
            PF[0][j] = A[0][j];
        }

        //While creating the PF sum, we need to do it for the element which is only one, because if the element is 0, the height breaks there
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    PF[i][j] = PF[i - 1][j] + A[i][j];
                }
            }
        }

        //For every row apply histogram logic to find the square
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            result = Math.max(result, largestRectangleInHistogram(PF[i]));
        }

        return result;
    }

    private static int largestRectangleInHistogram(int[] A) {
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
            stackLeft.add(i);

            while (!stackRight.isEmpty() && A[j] <= A[stackRight.peek()]) {
                stackRight.pop();
            }
            if (!stackRight.isEmpty()) {
                rightNearestSmall[j] = stackRight.peek();
            }
            stackRight.add(j);
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

    private static int solve_copied_from_discussion(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        int[][] row_prefix = new int[N][M];
        //To find the prefix sum row-wise.
        for (int i = 0; i < M; i++) {
            row_prefix[0][i] = A[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] == 1) {
                    if (row_prefix[i - 1][j] != 0) {
                        row_prefix[i][j] = A[i][j] + row_prefix[i - 1][j];
                    } else
                        row_prefix[i][j] = A[i][j];
                }
            }
        }


        int res = 0;
        //Using "Largest Rectangle in Histogram" algorithm to find the maximum area.
        for (int i = 0; i < N; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            int max_area = 0;

            for (int j = 1; j < M; j++) {
                if (row_prefix[i][j] < row_prefix[i][stack.peek()]) {
                    while (!stack.isEmpty() && row_prefix[i][j] < row_prefix[i][stack.peek()]) {
                        int index = stack.peek();
                        stack.pop();

                        if (stack.isEmpty())
                            max_area = Math.max(max_area, j * row_prefix[i][index]);
                        else
                            max_area = Math.max(max_area, (j - stack.peek() - 1) * row_prefix[i][index]);
                    }
                }
                stack.push(j);
            }

            while (!stack.isEmpty()) {
                int index = stack.peek();
                stack.pop();

                if (stack.isEmpty())
                    max_area = Math.max(max_area, M * row_prefix[i][index]);
                else
                    max_area = Math.max(max_area, (M - stack.peek() - 1) * row_prefix[i][index]);
            }
            res = Math.max(res, max_area);
        }

        return res;
    }
}