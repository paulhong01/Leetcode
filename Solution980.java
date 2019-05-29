// Leetcode 980: Unique Paths III
import java.util.*;

class Solution980 {
    int result = 0;
    int count = 0;
    int block = 0;
    public int uniquePathsIII(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == -1)   block++;
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    boolean[][] visited = new boolean[grid.length][grid[0].length];
                    backtracking(grid, i, j, visited);
                }
            }
        }
        return result;
    }
    
    private void backtracking(int[][] grid, int i, int j, boolean[][] visited) {
        if (grid[i][j] == 2) {
            if (count == grid.length*grid[0].length - 1 - block)
                result++;
            // System.out.printf("%d %d count: %d\n", i, j, result);
            return;
        }
        
        int[] dir = {0, 1, 0, -1, 0};
        for (int idx = 1; idx < dir.length; idx++) {
            int newi = i + dir[idx-1];
            int newj = j + dir[idx];

            if (newi >=0 && newi < grid.length && newj >= 0 && newj < grid[0].length && (grid[newi][newj] == 0 || grid[newi][newj] == 2) && !visited[newi][newj]) {
                // System.out.printf("%d %d\n", newi, newj);
                count++;
                visited[newi][newj] = true;
                backtracking(grid, newi, newj, visited);
                visited[newi][newj] = false;
                count--;
            }
        }
    }
}