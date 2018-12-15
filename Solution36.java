// Leetcode 36: Valid Sudoku
import java.util.*;

public class Solution36 {
    public boolean isValidSudoku(char[][] board) {
        // Method : Three pass
//         Set<Character> set = new HashSet();
//         // Check each column
//         for (int col = 0; col < 9; col++) {
//             set.clear();
//             for (int row = 0; row < 9; row++) {
//                 if (board[row][col] != '.' && set.contains(board[row][col]))    return false;
//                 else set.add(board[row][col]);
//             }
//         }
        
//         // Check each row
//         for (int row = 0; row < 9; row++) {
//             set.clear();
//             for (int col = 0; col < 9; col++) {
//                 if (board[row][col] != '.' && set.contains(board[row][col]))    return false;
//                 else set.add(board[row][col]);
//             }
//         }
        
//         // Check each block
//         for (int row = 0; row < 9; row += 3) {
//             for (int col = 0; col < 9; col += 3) {
//                 set.clear();
//                 for (int i = 0; i < 9; i++) {
//                     if (board[row+i/3][col+i%3] != '.' && set.contains(board[row+i/3][col+i%3]))    return false;
//                     else set.add(board[row+i/3][col+i%3]);
//                 }
//             }
//         }
//         return true;
        
        // Method 2: One pass
        for (int i = 0; i < 9; i++) {
            Set<Character> row = new HashSet();
            Set<Character> col = new HashSet();
            Set<Character> block = new HashSet();
            
            for (int j = 0; j < 9; j++) {
                // Check row
                if (board[i][j] != '.' && row.contains(board[i][j]))    return false;
                else    row.add(board[i][j]);
                
                // Check col
                if (board[j][i] != '.' && col.contains(board[j][i]))    return false;
                else col.add(board[j][i]);
                
                // Check block
                int temprow = i/3*3 + j/3;
                int tempcol = i%3*3 + j%3;
                if (board[temprow][tempcol] != '.' && block.contains(board[temprow][tempcol]))  return false;
                else block.add(board[temprow][tempcol]);
                
            }            
        }
        return true;
    }  
}