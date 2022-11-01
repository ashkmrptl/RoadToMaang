package scaler.matrix;

import java.util.Arrays;

/**
 * Given a matrix of integers A of size N x M and multiple queries Q, for each query, find and return the submatrix sum.
 * <p>
 * Inputs to queries are top left (b, c) and bottom right (d, e) indexes of submatrix whose sum is to find out.
 * <p>
 * NOTE:
 * <p>
 * Rows are numbered from top to bottom, and columns are numbered from left to right.
 * Sum may be large, so return the answer mod 109 + 7.
 */
public class SubMatrixSumQueries {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] B = new int[]{1, 2};
        int[] C = new int[]{1, 2};
        int[] D = new int[]{2, 3};
        int[] E = new int[]{2, 3};

        System.out.println(Arrays.toString(solve(A, B, C, D, E)));

        A = new int[][]{{5, 17, 100, 11}, {0, 0, 2, 8}};
        B = new int[]{1, 1};
        C = new int[]{1, 4};
        D = new int[]{2, 2};
        E = new int[]{2, 4};

        System.out.println(Arrays.toString(solve(A, B, C, D, E)));
    }

    private static int[] solve(int[][] A, int[] B, int[] C, int[] D, int[] E) {
        int n = A.length;
        int m = A[0].length;

        long[][] pf = new long[n][m];

        //Row
        for (int i = 0; i < n; i++) {
            pf[i][0] = A[i][0];
            for (int j = 1; j < m; j++) {
                long sum = A[i][j] + pf[i][j - 1];
                pf[i][j] = (int) (sum % 1000000007);
            }
        }

        //Col
        for (int j = 0; j < m; j++) {
            pf[0][j] = pf[0][j];
            for (int i = 1; i < n; i++) {
                long sum = pf[i][j] + pf[i - 1][j];
                pf[i][j] = (int) (sum % 1000000007);
            }
        }

        int[] ans = new int[B.length];

        for (int i = 0; i < B.length; i++) {
            int b = B[i] - 1;
            int c = C[i] - 1;
            int d = D[i] - 1;
            int e = E[i] - 1;

            long sum = pf[d][e];

            if (b > 0) {
                sum -= pf[b - 1][e];
            }

            if (c > 0) {
                sum -= pf[d][c - 1];
            }

            if (b > 0 && c > 0) {
                sum += pf[b - 1][c - 1];
            }
            sum %= 1000000007;
            if (sum < 0) {
                sum += 1000000007;
            }

            ans[i] = (int) sum % 1000000007;
        }

        return ans;
    }
}
