package companies.walmart;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix m * n, return all elements of the matrix in spiral order
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        System.out.println(spiralOrder(matrix));

        matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));
    }

    private static List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] points = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        int count = 0;
        int[] lastPoint = new int[]{0, -1};
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; count < (m * n); i++) {
            if (i == points.length) {
                i = 0;
            }
            int[] point = points[i];

            int start = lastPoint[0] + point[0];
            int end = lastPoint[1] + point[1];

            while (start >= 0 && start < m && end >= 0 && end < n && matrix[start][end] != 101) {
                //System.out.print(matrix[start][end] + " ");
                answer.add(matrix[start][end]);
                matrix[start][end] = 101;
                count++;

                lastPoint[0] = start;
                lastPoint[1] = end;
                start += point[0];
                end += point[1];
            }
        }

        return answer;
    }
}
