package scaler.backTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.
 * <p>
 * Given an integer A, return all distinct solutions to the n-queens puzzle.
 * <p>
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
 * The final list should be generated in such a way that the indices of the queens in each list should be in reverse lexicographical order.
 */
public class NQueens {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(solve(2)));
        System.out.println(Arrays.deepToString(solve(3)));
        System.out.println(Arrays.deepToString(solve(4)));
    }

    private static String[][] solve(int A) {
        final List<List<String>> result = new ArrayList<>();

        final boolean[] col = new boolean[A];
        Arrays.fill(col, true);

        final boolean[] fwdDiag = new boolean[A * 2];
        Arrays.fill(fwdDiag, true);

        final boolean[] bckDiag = new boolean[A * 2];
        Arrays.fill(bckDiag, true);

        final int[][] board = new int[A][A];

        findPlacement(A, 0, col, fwdDiag, bckDiag, board, result);

        if (result.size() == 0) {
            return new String[0][0];
        }

        final String[][] answer = new String[result.size()][result.get(0).size()];
        for (int i = 0; i < result.size(); i++) {
            final List<String> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                answer[i][j] = list.get(j);
            }
        }
        return answer;
    }

    private static void findPlacement(final int A, final int row, final boolean[] col, final boolean[] fwdDiag, final boolean[] bckDiag, final int[][] borad, final List<List<String>> result) {
        if (row == A) {
            //Go over board to generate the board with queens placement
            final List<String> list = new ArrayList<>();
            for (int i = 0; i < borad.length; i++) {
                final StringBuilder sb = new StringBuilder();
                for (int j = 0; j < borad[0].length; j++) {
                    if (borad[i][j] == 1) {
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }

        //We try to put queens on all the columns of the row
        for (int column = 0; column < A; column++) {
            if (!col[column] || !fwdDiag[row + column] || !bckDiag[A + (row - column)]) {
                continue; //Can not place the queen, hence move to next col
            }

            //Place the queen(DO)
            borad[row][column] = 1;

            //Mark respective column and diagonals as false;
            col[column] = false;
            fwdDiag[row + column] = false;
            bckDiag[A + (row - column)] = false;

            findPlacement(A, row + 1, col, fwdDiag, bckDiag, borad, result);

            //Remove the queen(UNDO)
            borad[row][column] = 0;

            //Mark respective column and diagonals as true;
            col[column] = true;
            fwdDiag[row + column] = true;
            bckDiag[A + (row - column)] = true;
        }
    }
}
