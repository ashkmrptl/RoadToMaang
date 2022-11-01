package scaler.searching;

/**
 * Given a matrix of integers A of size N x M in which each row is sorted.
 * Find and return the overall median of matrix A.
 * NOTE: No extra memory is allowed.
 * NOTE: Rows are numbered from top to bottom and columns are numbered from left to right.
 */
public class MatrixMedian {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        System.out.println(solve(A));

        A = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        System.out.println(solve(A));

        A = new int[][]{{5, 17, 100}};
        System.out.println(solve(A));
    }

    private static int solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            start = Math.min(start, A[i][0]);
            end = Math.max(end, A[i][cols - 1]);
        }

        int median = (rows * cols) / 2;

        while (start <= end) {
            int mid = (start + end) / 2;

            int countOfSmallerElements = 0;
            for (int i = 0; i < rows; i++) {
                countOfSmallerElements = countOfSmallerElements + countSmaller(A[i], mid);
            }

            if (countOfSmallerElements <= median) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;

    }

    private static int countSmaller(int[] A, int B) {
        int low = 0;
        int high = A.length - 1;

        int count = 0;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (A[mid] <= B) {
                count = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return count;
    }
}
