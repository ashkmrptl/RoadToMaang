package scaler.matrix;

/**
 * Given a matrix of integers A of size N x M and an integer B.
 * In the given matrix every row and column is sorted in increasing order. Find and return the position of B in the matrix in the given form:
 * If A[i][j] = B then return (i * 1009 + j)
 * If B is not present return -1.
 * <p>
 * Note 1: Rows are numbered from top to bottom and columns are numbered from left to right.
 * Note 2: If there are multiple B in A then return the smallest value of i*1009 +j such that A[i][j]=B.
 */
public class SearchInRowWiseColWiseSortedMatrix {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int B = 2;
        System.out.println(solve(A, B));

        A = new int[][]{{1, 3, 5, 7}, {2, 4, 6, 8}};
        B = 10;
        System.out.println(solve(A, B));

        A = new int[][]{{2, 8, 8, 8}, {2, 8, 8, 8}, {2, 8, 8, 8}};
        B = 8;
        System.out.println(solve(A, B));
    }

    private static int solve(int[][] A, int B) {
        int ans = Integer.MAX_VALUE;

        int n = A.length;
        int m = A[0].length;

        //Starting from top right cell
        int i = 0;
        int j = m - 1;

        while (i < n && j >= 0) {
            if (A[i][j] == B) {
                int res = ((i + 1) * 1009) + (j + 1);
                ans = Math.min(ans, res);
                j--;
            } else if (A[i][j] < B) {
                i++;
            } else if (A[i][j] > B) {
                j--;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
