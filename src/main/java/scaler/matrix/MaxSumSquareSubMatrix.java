package scaler.matrix;

public class MaxSumSquareSubMatrix {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 1, 1, 1, 1}, {2, 2, 2, 2, 2}, {3, 8, 6, 7, 3}, {4, 4, 4, 4, 4}, {5, 5, 5, 5, 5}};
        int B = 3;

        System.out.println(solve(A, B));

        A = new int[][]{{2, 2}, {2, 2}};
        B = 2;

        System.out.println(solve(A, B));
    }

    private static int solve(int[][] A, int B) {
        int rows = A.length;
        int cols = A[0].length;

        int[][] pf = new int[rows][cols];
        //Prefix sum array
        //Row
        for (int i = 0; i < rows; i++) {
            pf[i][0] = A[i][0];
            for (int j = 1; j < cols; j++) {
                pf[i][j] = pf[i][j - 1] + A[i][j];
            }
        }

        //Col
        for (int j = 0; j < cols; j++) {
            pf[0][j] = pf[0][j];
            for (int i = 1; i < rows; i++) {
                pf[i][j] += pf[i - 1][j];
            }
        }

        if (B == rows) {
            return pf[rows - 1][cols - 1];
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i <= rows - B; i++) {
            for (int j = 0; j <= cols - B; j++) {
                //top left
                int b = i;
                int c = j;
                //bottom right
                int d = i + B - 1;
                int e = j + B - 1;

                int sum = pf[d][e];
                if (b > 0) {
                    sum -= pf[b - 1][e];
                }
                if (c > 0) {
                    sum -= pf[d][c - 1];
                }
                if (b > 0 && c > 0) {
                    sum += pf[b - 1][c - 1];
                }

                maxSum = Math.max(sum, maxSum);
            }
        }

        return maxSum;
    }
}
