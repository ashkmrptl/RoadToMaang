package scaler.matrix;

public class SpiralPrinting {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        printSpiral1(A, A.length, A[0].length);
        System.out.println();

        A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {10, 11, 12}, {13, 14, 15}};
        printSpiral1(A, A.length, A[0].length);
        System.out.println();

        A = new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}};
        printSpiral1(A, A.length, A[0].length);
    }

    private static void printSpiral1(int[][] A, int n, int m) {
        int startRow = 0;
        int startCol = 0;

        int endRow = n - 1;
        int endCol = m - 1;

        int i;

        while (startRow <= endRow && startCol <= endCol) {
            for (i = startCol; i <= endCol; i++) {
                System.out.print(A[startRow][i] + " ");
            }
            startRow++;

            for (i = startRow; i <= endRow; i++) {
                System.out.print(A[i][endCol] + " ");
            }
            endCol--;

            if (startRow < endRow) {
                for (i = endCol; i >= startCol; i--) {
                    System.out.print(A[endRow][i] + " ");
                }
                endRow--;
            }

            if (startCol < endCol) {
                for (i = endRow; i >= startRow; i--) {
                    System.out.print(A[i][startCol] + " ");
                }
                startCol++;
            }
        }

    }
}
