package scaler.matrix;

import java.util.Arrays;

public class MatrixRotation {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printMatrix(A);

        rotate90DegreeClockwise(A);
    }

    private static void rotate90DegreeClockwise(final int[][] A) {
        //Get the transpose matrix
        for (int i = 0; i < A.length; i++) {
            for (int j = i + 1; j < A.length; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }
        System.out.println("Transpose Matrix : ");
        printMatrix(A);

        //swap rows
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A.length / 2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][A.length - 1 - j];
                A[i][A.length - 1 - j] = temp;
            }
        }

        System.out.println("Rotated matrix : ");
        printMatrix(A);
    }

    private static void printMatrix(final int[][] A) {
        for (int[] a : A) {
            System.out.println(Arrays.toString(a));
        }
    }
}
