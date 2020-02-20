// Leetcode 1351: Count Negative Numbers in a Sorted Matrix
import java.util.*;

class Solution1351 {
    public int countNegatives(int[][] grid) {
        // TC:O(M+N), SC:O(1), M = grid.length, N = grid[0].length
        if (grid == null) {
            return 0;
        }
        
        int M = grid.length, N = grid[0].length;
        int row = M - 1, col = 0;
        int count = 0;
        while (row >= 0 && col <= N - 1) {
            if (grid[row][col] < 0) {
                count += N - col;
                row--;
            } else {
                col++;
            }
        }
        return count;
    }
}