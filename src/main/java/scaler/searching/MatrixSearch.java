package scaler.searching;

public class MatrixSearch {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(search(A, 3));
        System.out.println(search(A, 5));

        A = new int[][]{{5, 17, 100, 111}, {111, 120, 127, 131}};
        System.out.println(search(A, 3));
        System.out.println(search(A, 127));
    }

    private static int search(int[][] A, int B) {
        int rows = A.length;
        int cols = A[0].length;

        int startRow = 0;
        int startCol = 0;

        int endRow = rows - 1;
        int endCol = cols - 1;

        //Determine row
        while (startRow <= endRow) {
            int midRow = (startRow + endRow) / 2;

            if (A[midRow][startCol] <= B && B <= A[midRow][endCol]) {//Search in the row
                while (startCol <= endCol) {
                    int midCol = (startCol + endCol) / 2;

                    if (A[midRow][midCol] == B) {
                        return 1;
                    } else if (B < A[midRow][midCol]) {
                        endCol = midCol - 1;
                    } else if (B > A[midRow][midCol]) {
                        startCol = midCol + 1;
                    }
                }
            } else if (B < A[midRow][startCol]) {
                endRow = midRow - 1;
            } else if (B > A[midRow][endCol]) {
                startRow = midRow + 1;
            }
        }

        return 0;
    }
}
