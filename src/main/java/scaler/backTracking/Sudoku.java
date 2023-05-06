package scaler.backTracking;

import java.util.Arrays;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells. Empty cells are indicated by the character '.' You may assume that there will be only one unique solution.
 */
public class Sudoku {
    public static void main(String[] args) {
        char[][] A = new char[][] {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        solveSudoku(A);

        System.out.println(Arrays.deepToString(A));
    }

    private static void solveSudoku(char[][] A) {
        solveWithBackTrack(0, A);
    }

    private static boolean solveWithBackTrack(int index, char[][] A) {
        if (index == 81) {
            return true;
        }
        int row = index / 9;
        int col = index % 9;

        if(A[row][col] != '.') {
            return solveWithBackTrack(index + 1, A);
        } else {
            for (int i = 1; i <= 9; i++ ) {
                char charToAdd = (char) (i + '0');

                if (isValid(row, col, charToAdd, A)) {//if "i" can be placed at A[row][col]
                    A[row][col] = charToAdd; //DO

                    if (solveWithBackTrack(index + 1, A)) {
                        return true;
                    }

                    A[row][col] = '.'; //UNDO
                }
            }
        }
        return false;
    }

    private static boolean isValid(int row, int col, char ch, char[][] A){
        //check in row and col
        for(int i = 0; i < 9; i++){
            if(A[i][col] == ch || A[row][i] == ch)
                return false;
        }

        //check in 3x3 grid
        int x = row - (row % 3);
        int y = col - (col % 3);

        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                if(A[x+i][y+j] == ch)
                    return false;
            }
        }

        return true;
    }
}
