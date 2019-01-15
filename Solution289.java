// Leetcode 289: Game of Life
import java.util.*;

class Solution289 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
    int m = board.length, n = board[0].length;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int lives = check(board, i, j);

            // In the beginning, every 2nd bit is 0;
            // So we only need to care about when will the 2nd bit become 1.
            if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
            }
            if (board[i][j] == 0 && lives == 3) {
                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
            }
        }
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            board[i][j] >>= 1;  // Get the 2nd state.
        }
    }
    }
    
    private int check(int[][] board, int i, int j) {
        int result = 0;
        int m = board.length, n = board[0].length;
        for (int x = Math.max(i-1, 0); x <= Math.min(i+1, m-1); x++) {
            for (int y = Math.max(j-1, 0); y <= Math.min(j+1, n-1); y++) {
                result += (board[x][y] & 1);
            }
        }
        result -= board[i][j];
        return result;
    }
}