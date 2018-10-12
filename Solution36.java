// Leetcode 36: Valid Sudoku
import java.util.*;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        // TC:O(n^2), SC:O(n)
        Set<Character> set = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!set.add(board[i][j]) && board[i][j] != '.')    return false;
            }
            set.clear();
        }
        
        set.clear();
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                if (!set.add(board[i][j]) && board[i][j] != '.')    return false;
            }
            set.clear();
        }       

        set.clear();
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                for (int ini = 0; ini < 3; ini++) {
                    for (int inj = 0; inj < 3; inj++) {
                        if ( board[i+ini][j+inj] != '.' && !set.add(board[i+ini][j+inj]))    return false;
                    }
                }
                set.clear();
            }
        }
        return true;
        
    }
}