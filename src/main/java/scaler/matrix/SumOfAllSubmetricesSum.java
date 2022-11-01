package scaler.matrix;

public class SumOfAllSubmetricesSum {
    public static void main(String[] args) {
        int[][] A = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(solve(A));

        A = new int[][]{{1, 1}, {1, 1}};
        System.out.println(solve(A));
    }

    /**
     * The contribution technique can be used to fina this in optimized way.
     * So, the formula to find the count of no of occurrences(in all sub-matrices) of a cell(i, j) in a matrix of size n * m is
     * (i + 1) * (n - i)     *     (j + 1) * (m - j)
     * <----------------->         <----------------->
     * (contribution in row       (contribution in sum sub-arrays)
     * sub-arrays)
     */
    private static int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int sum = 0;

        for (int i = 0; i < n; i++) {//row
            for (int j = 0; j < m; j++) {//col
                sum += ((i + 1) * (n - i) * (j + 1) * (m - j) * A[i][j]);
            }
        }

        return sum;
    }
}
