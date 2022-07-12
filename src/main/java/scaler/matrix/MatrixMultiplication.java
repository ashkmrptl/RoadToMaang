package scaler.matrix;

import java.util.Arrays;

public class MatrixMultiplication {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2}, {3, 4}};
        int[][] B = new int[][]{{5, 6}, {7, 8}};

        int n = A.length;
        int m = A[0].length;

        int x = B.length;
        int y = B[0].length;

        printMatrix(solve(n, m, A, x, y, B));

        A = new int[][]{{94, 91}};
        B = new int[][]{{35, -52, -12, 26, -93, -61}, {29, -20, -36, -9, 66, 15}};

        n = A.length;
        m = A[0].length;

        x = B.length;
        y = B[0].length;

        printMatrix(solve(n, m, A, x, y, B));
    }

    private static int[][] solve(final int n, final int m, final int[][] A, final int x, final int y, final int[][] B) {
        final int[][] res = new int[n][y];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < y; j++) {
                for (int k = 0; k < x; k++) {
                    System.out.println("i : " + i + " j : " + j + " k : " + k);
                    res[i][j] += A[i][k] * B[k][j];
                }
                System.out.println("--------------------------------");
            }
        }

        return res;
    }

    private static void printMatrix(final int[][] A) {
        for (int[] a : A) {
            System.out.println(Arrays.toString(a));
        }
    }
}
