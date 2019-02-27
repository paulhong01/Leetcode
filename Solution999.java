// Leetcode 999: Available Captures for Rook
import java.util.*;

class Solution999 {
    private int check(char[][] board, int i, int j, int dx, int dy) {
        while (i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] != 'B') {
            if (board[i][j] == 'p') return 1;
            i += dx;
            j += dy;
        }
        return 0;
    }
    
    public int numRookCaptures(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'R') {
                    return check(board, i, j, 0, 1) + check(board, i, j, 0, -1) + check(board, i, j, 1, 0) + check(board, i, j, -1, 0);
                }
            }
        }
        return 0;
    }
}