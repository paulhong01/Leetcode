// Leetcode 130: Surrounded Regions
import java.util.*;

class Solution130 {
    public void solve(char[][] board) {
        // TC:O(MN), SC:O(1)
        if (board.length < 1) {
            return;
        }
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                traversal(board, i, 0);
            }
            if (board[i][n-1] == 'O') {
                traversal(board, i, n-1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                traversal(board, 0, i);
            }
            if (board[m-1][i] == 'O') {
                traversal(board, m-1, i);
            }
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }
    
    private void traversal(char[][] board, int x, int y) {
        board[x][y] = '1';
        
        int[] dir = {0, 1, 0, -1, 0};
        for (int i = 1; i < dir.length; i++) {
            int newx = x + dir[i-1];
            int newy = y + dir[i];
            if (newx>=0 && newx<board.length && newy>=0 && newy < board[0].length && board[newx][newy] == 'O') {
                traversal(board, newx, newy);
            }
        }
    }
}