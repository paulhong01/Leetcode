// Leetcode 37: Sudoku Solver
import java.util.*;

public class Solution37 {
    public static void main(String[] args) {
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        Solution37 sol = new Solution37();
        sol.solveSudoku(board);
        for (char[] b: board) {
            for (char b_c: b) {
                System.out.printf("%c ", b_c);
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) return;
        traversal(board);
    }

    private boolean traversal(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    for (char c = '1'; c <= '9'; c++) {
                        if (checkValid(board, i, j, c)) {
                            board[i][j] = c;

                            if (traversal(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkValid(char[][] board, int row, int col, char c) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c || board[i][col] == c || board[row/3*3+i/3][col/3*3+i%3] == c)   return false;
        }
        return true;
    }
}
