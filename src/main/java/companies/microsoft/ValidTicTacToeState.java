package companies.microsoft;

public class ValidTicTacToeState {
    public static void main(String[] args) {
        String[] board = new String[]{"O  ", "   ", "   "};
        System.out.println(validTicTacToe(board));

        board = new String[]{"XOX", " X ", "   "};
        System.out.println(validTicTacToe(board));

        board = new String[]{"XOX", "O O", "XOX"};
        System.out.println(validTicTacToe(board));
    }

    /**
     * Approach:
     * When turns is 1, X moved. When turns is 0, O moved. rows stores the number of X or O in each row. C
     * cols stores the number of X or O in each column. diag stores the number of X or O in diagonal.
     * antidiag stores the number of X or O in antidiagonal. When any of the value gets to 3, it means X wins.
     * When any of the value gets to -3, it means O wins.
     * <p>
     * When X wins, O cannot move anymore, so turns must be 1. When O wins, X cannot move anymore, so turns must be 0.
     * Finally, when we return, turns must be either 0 or 1, and X and O cannot win at same time.
     */
    private static boolean validTicTacToe(String[] board) {
        int turns = 0;

        boolean xWin;
        boolean oWin;

        int[] rows = new int[3];
        int[] cols = new int[3];

        int diag = 0;
        int antiDiag = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'X') {
                    turns++;
                    rows[i]++;
                    cols[j]++;
                    if (i == j) {
                        diag++;
                    }
                    if (i + j == 2) {
                        antiDiag++;
                    }
                } else if (board[i].charAt(j) == 'O') {
                    turns--;
                    rows[i]--;
                    cols[j]--;
                    if (i == j) {
                        diag--;
                    }
                    if (i + j == 2) {
                        antiDiag--;
                    }
                }
            }
        }

        xWin = rows[0] == 3 || rows[1] == 3 || rows[2] == 3 ||
                cols[0] == 3 || cols[1] == 3 || cols[2] == 3 ||
                diag == 3 || antiDiag == 3;
        oWin = rows[0] == -3 || rows[1] == -3 || rows[2] == -3 ||
                cols[0] == -3 || cols[1] == -3 || cols[2] == -3 ||
                diag == -3 || antiDiag == -3;

        if (xWin && turns == 0 || oWin && turns == 1) {
            return false;
        }
        return turns == 0 || turns == 1;
    }
}
