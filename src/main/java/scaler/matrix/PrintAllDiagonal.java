package scaler.matrix;


import java.util.Arrays;

public class PrintAllDiagonal {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] res = solve(A);

        printMatrix(res);
    }

    private static int[][] solve(final int[][] A) {
        final int n = A.length;
        final int[][] res = new int[(2 * n) - 1][n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            res[index] = getDiagonal(0, i, n, A);
            index++;
        }

        for (int i = 1; i < n; i++) {
            res[index] = getDiagonal(i, n - 1, n, A);
            index++;
        }

        return res;
    }

    private static int[] getDiagonal(final int start, final int end, final int n, int[][] A) {
        final int[] result = new int[n];

        int k = 0;
        int j = end;
        int i = start;

        while (i < n && j >= 0) {
            result[k] = A[i][j];
            k++;
            i++;
            j--;
        }

        return result;
    }

    private static void printMatrix(final int[][] A) {
        for (int[] a : A) {
            System.out.println(Arrays.toString(a));
        }
    }
}
