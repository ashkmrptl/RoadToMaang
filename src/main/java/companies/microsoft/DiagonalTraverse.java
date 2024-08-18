package companies.microsoft;

import java.util.Arrays;

public class DiagonalTraverse {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(findDiagonalOrder(mat)));
    }

    private static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] ans = new int[m * n];

        int i = 0;
        int row = 0;
        int col = 0;

        boolean up = true;

        while (row < m && col < n) {
            if (up) {
                while (row > 0 && col < n - 1) {
                    ans[i++] = mat[row][col];
                    row--;
                    col++;
                }
                ans[i++] = mat[row][col];
                if (col == n - 1) {
                    row++;
                } else {
                    col++;
                }
            } else {
                while (col > 0 && row < m - 1) {
                    ans[i++] = mat[row][col];
                    row++;
                    col--;
                }
                ans[i++] = mat[row][col];
                if (row == m - 1) {
                    col++;
                } else {
                    row++;
                }
            }

            up = !up;
        }
        return ans;
    }
}
