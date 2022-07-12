package scaler.matrix;

import java.util.Arrays;

/**
 * You are given two matrices A & B of same size, you have to return another matrix which is the sum of A and B.
 */
public class AddTheMatrices {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] B = new int[][]{{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};

        printMatrix(solve(A, B));

        A = new int[][]{{6}, {2}, {3}, {10}, {1}, {3}};
        B = new int[][]{{6}, {7}, {3}, {8}, {1}, {2}};

        printMatrix(solve(A, B));
    }

    private static int[][] solve(int[][] A, int[][] B) {
        final int n = A.length;
        int m = A[0].length;
        System.out.println("n : " + n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("i : " + i + " j : " + j);
                A[i][j] = A[i][j] + B[i][j];
            }
        }
        return A;
    }

    public static void printMatrix(final int[][] A) {
        for (int[] a : A) {
            System.out.println(Arrays.toString(a));
        }

    }
}
