package scaler.matrix;

/**
 * Given a row-wise and column-wise sorted matrix A of size N * M.
 * Return the maximum non-empty sub-matrix sum of this matrix.
 */
public class MaxSubMatrixSum {
    public static void main(String[] args) {
        int[][] A = new int[][]{{-5, -4, -3}, {-1, 2, 3}, {2, 2, 4}};
        System.out.println(solve(A));

        A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solve(A));
    }

    /**
     * As it is given that the matrix is sorted, the element which we must consider id (n-1, m - 1).
     * So, the bottom right is fixed.
     * Now we consider all possible top-right cell and calculate sum. The max of them will be the answer.
     */
    private static long solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        long[][] pf = new long[n][m];

        //Calculate PF array
        //Row wise
        for (int i = 0; i < n; i++) {
            pf[i][0] = A[i][0];
            for (int j = 1; j < m; j++) {
                pf[i][j] = A[i][j] + pf[i][j - 1];
            }
        }

        //Col wise
        for (int j = 0; j < m; j++) {
            pf[0][j] = pf[0][j];
            for (int i = 1; i < n; i++) {
                pf[i][j] += pf[i - 1][j];
            }
        }

        //Fixed Bottom-right
        int d = n - 1;
        int e = m - 1;

        long sum = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int b = i;
                int c = j;
                long temp = getSum(pf, b, c, d, e);
                sum = Math.max(sum, temp);
            }
        }

        return sum;
    }

    private static long getSum(long[][] A, int b, int c, int d, int e) {
        long sum = A[d][e];

        if (b > 0) {
            sum -= A[b - 1][e];
        }

        if (c > 0) {
            sum -= A[d][c - 1];
        }

        if (b > 0 && c > 0) {
            sum += A[b - 1][c - 1];
        }

        return sum;
    }
}
