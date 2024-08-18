package companies.microsoft;

public class RangeSumQuery2D {
    public static void main(String[] args) {
        final int[][] mat = new int[][]{{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        final NumMatrix matrix = new NumMatrix(mat);
        System.out.println(matrix.sumRegion(2, 1, 4, 3));
        System.out.println(matrix.sumRegion(1, 1, 2, 2));
        System.out.println(matrix.sumRegion(1, 2, 2, 4));
    }

    private static class NumMatrix {
        private final int[][] pfSum;

        public NumMatrix(int[][] matrix) {
            pfSum = new int[matrix.length][matrix[0].length];

            //Row wise
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (j == 0) {
                        pfSum[i][j] = matrix[i][j];
                    } else {
                        pfSum[i][j] = pfSum[i][j - 1] + matrix[i][j];
                    }
                }
            }

            //Column wise
            for (int j = 0; j < matrix[0].length; j++) {
                for (int i = 0; i < matrix.length; i++) {
                    if (i == 0) {
                        pfSum[i][j] = pfSum[i][j];
                    } else {
                        pfSum[i][j] = pfSum[i - 1][j] + pfSum[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int sum = 0;

            if (row1 == 0) {
                if (col1 == 0) {
                    sum += pfSum[row2][col2];
                } else {
                    int rowSum2 = pfSum[row2][col2];
                    int rowSum1 = pfSum[row2][col1 - 1];
                    sum += rowSum2 - rowSum1;
                }
            } else {
                if (col1 == 0) {
                    sum += pfSum[row2][col2] - pfSum[row1 - 1][col2];
                } else {
                    int rowSum2 = pfSum[row2][col2] - pfSum[row1 - 1][col2];
                    int rowSum1 = pfSum[row2][col1 - 1] - pfSum[row1 - 1][col1 - 1];
                    sum += rowSum2 - rowSum1;
                }
            }

            return sum;
        }

        public int sumRegion_not_constant_time(int row1, int col1, int row2, int col2) {
            int sum = 0;

            for (int i = row1; i <= row2; i++) {
                if (col1 == 0) {
                    sum += pfSum[i][col2];
                } else {
                    sum += pfSum[i][col2] - pfSum[i][col1 - 1];
                }
            }

            return sum;
        }
    }
}
