package scaler.matrix;

import java.util.Arrays;

/**
 * Generate spiral matrix from 1 to A*A
 */
public class CreateSpiralOrderMatrix {
    public static void main(String[] args) {
        printMatrix(generateSpiralMatrix(3));
    }

    private static int[][] generateSpiralMatrix(final int A) {
        final int[][] result = new int[A][A];

        int startRow = 0, startCol = 0, endRow = A - 1, endCol = A - 1, i, num = 1;

        while (startRow <= endRow && startCol <= endCol) {
            for (i = startCol; i <= endCol; i++) {
                result[startRow][i] = num;
                num++;
            }
            startRow++;

            for (i = startRow; i <= endRow; i++) {
                result[i][endCol] = num;
                num++;
            }
            endCol--;

            if (startRow < endRow) {
                for (i = endCol; i >= startCol; i--) {
                    result[endRow][i] = num;
                    num++;
                }
                endRow--;
            }

            if (startCol < endCol) {
                for (i = endRow; i >= startRow; i--) {
                    result[i][startCol] = num;
                    num++;
                }
                startCol++;
            }
        }
        return result;
    }

    private static void printMatrix(final int[][] A) {
        for (int[] a : A) {
            System.out.println(Arrays.toString(a));
        }
    }
}
