package scaler.matrix;

/**
 * Given a N * M 2D matrix A. Find the maximum sum sub-matrix from the matrix A. Return the Sum.
 */
public class MaxSumSubMatrix {
    public static void main(String[] args) {
        int[][] A = new int[][]{{-6, -6}, {-29, -8}, {3, -8}, {-15, 2}, {25, 25}, {20, -5}};
        System.out.println(solve(A));

        A = new int[][]{{-6, -6}, {-3, -4}, {1, -2}, {8, -1}};
        System.out.println(solve(A));
    }

    /**
     * The approach is to use the Kadane's algorithm
     */
    private static int solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int left = 0;
        int right = 0;
        int top = 0;
        int bottom = 0;
        int subMatrixSum = Integer.MIN_VALUE;

        int[] temp = new int[rows];
        for (int j = 0; j < cols; j++) {//Fixing row
            for (int k = j; k < cols; k++) {//For all rows starting from j
                int curr = 0;
                int start = 0;
                int sum = Integer.MIN_VALUE;

                int maxEnd = -1;
                int maxStart = 0;

                for (int i = 0; i < rows; i++) {//For all elements in column k
                    temp[i] += A[i][k];

                    curr += temp[i];
                    if (curr > sum) {
                        sum = curr;
                        maxStart = start;
                        maxEnd = i;
                    }
                    if (curr < 0) {
                        curr = 0;
                        start = i + 1;
                    }
                }
                if (sum > subMatrixSum) {
                    subMatrixSum = sum;
                    left = j;
                    right = k;
                    top = maxStart;
                    bottom = maxEnd;
                }
                maxEnd = -1;
                maxStart = 0;
            }
            temp = new int[rows];
        }

        System.out.printf("Top left : (%s, %s) and Bottom right : (%s, %s)", top, left, bottom, right);

        return subMatrixSum;
    }
}
