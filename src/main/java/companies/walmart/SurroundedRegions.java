package companies.walmart;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. Surrounded Regions
 * https://leetcode.com/problems/surrounded-regions/description/
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        solve(board);
        print(board);
    }

    private static void print(final char[][] board) {
        for (char[] a : board) {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
    }

    private static void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }

        int n = board.length;
        int m = board[0].length;

        // Mark the 'O's on the edge and their connected as safe
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O') {
                markEdgeConnected(board, i, 0);
            }
            if (board[i][m - 1] == 'O') {
                markEdgeConnected(board, i, m - 1);
            }
        }

        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O') {
                markEdgeConnected(board, 0, j);
            }
            if (board[n - 1][j] == 'O') {
                markEdgeConnected(board, n - 1, j);
            }
        }

        // Capture all remaining 'O's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        // Restore the marked 'O's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private static void markEdgeConnected(char[][] board, int i, int j) {
        final int n = board.length;
        final int m = board[0].length;

        final int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

        final Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});

        //Mark current as visited
        board[i][j] = 'A';

        while (!queue.isEmpty()) {
            final int[] current = queue.poll();

            for (int[] direction : directions) {
                int row = current[0] + direction[0];
                int col = current[1] + direction[1];

                if (row >= 0 && row < n && col >= 0 && col < m && board[row][col] == 'O') {
                    board[row][col] = 'A';
                    queue.add(new int[]{row, col});
                }
            }
        }
    }
}