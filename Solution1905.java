// Leetcode 1905: Count Sub Islands
import java.util.*;

class Solution1905 {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        // TC:O(MN), SC:O(1)
        int M = grid1.length, N = grid1[0].length, result = 0;
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1) {
                    result += check(i, j, grid1, grid2);
                }
            }
        }
        return result;
    }
    
    public int check(int row, int col, int[][] grid1, int[][] grid2) {
        int M = grid1.length, N = grid1[0].length, result = 1;
        if (row < 0 || row == M || col < 0 || col == N || grid2[row][col] == 0) {
            return 1;
        }
        grid2[row][col] = 0;
        result &= check(row+1, col, grid1, grid2);
        result &= check(row-1, col, grid1, grid2);
        result &= check(row, col+1, grid1, grid2);
        result &= check(row, col-1, grid1, grid2);
        return result & grid1[row][col];
    }
}