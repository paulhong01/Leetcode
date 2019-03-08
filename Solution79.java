// Leetcode 79: Word Search
import java.util.*;

class Solution79 {
    public boolean exist(char[][] board, String word) {
        // TC:O(mn), SC:O(mn)
        int col = board.length;
        int row = board[0].length;
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[col][row];
                    if (check(board, i, j, word, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean check(char[][] board, int i, int j, String word, int idx, boolean[][] visited) {
        if (idx == word.length())   return true;
        
        visited[i][j] = true;
        int[] step = {0, 1, 0, -1, 0};
        for (int x = 1; x < step.length; x++) {
            int nexti = i + step[x-1], nextj = j + step[x];
            if (idx+1 == word.length())   return true;
            else if ((nexti >= 0) && (nexti < board.length) && (nextj >= 0) && (nextj < board[0].length) && !(visited[nexti][nextj]) && (board[nexti][nextj] == word.charAt(idx+1))) {
                if (check(board, nexti, nextj, word, idx+1, visited))   return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}