package companies.intuit;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        System.out.println(exist(board, word));

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word = "SEE";
        System.out.println(exist(board, word));

        board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        word = "ABCB";
        System.out.println(exist(board, word));
    }

    private static boolean exist(char[][] board, String word) {
        //boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean res = dfs(board, i, j, 0, word/*, visited*/);
                    if (res) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, int index, String word/*, boolean[][] visited*/) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length /*|| visited[i][j]*/ || index >= word.length() || board[i][j] != word.charAt(index)) {
            return false;
        }

        /*if (index == word.length() - 1) {
            return true;
        }*/

        //visited[i][j] = true;
        board[i][j] = '#';

        boolean res = dfs(board, i + 1, j, index + 1, word/*, visited*/) ||
                dfs(board, i - 1, j, index + 1, word/*, visited*/) ||
                dfs(board, i, j + 1, index + 1, word/*, visited*/) ||
                dfs(board, i, j - 1, index + 1, word/*, visited*/);

        //visited[i][j] = false;
        board[i][j] = word.charAt(index);

        return res;
    }
}
