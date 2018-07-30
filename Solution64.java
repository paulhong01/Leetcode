// Leetcode 64: Minimum Path Sum
import java.util.*;

public class Solution64 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},
                        {1,5,1},
                        {4,2,1}};

        Solution64 sol = new Solution64();
        int res = sol.minPathSum(grid);
        System.out.println(res);
    }

    private int result = Integer.MAX_VALUE;

    public int minPathSum(int[][] grid) {
        // Method 1: DFS
        // List<Integer> list = new ArrayList();
        // traversal(0, 0, 0, grid);
        // return result;

        // Method 2: TC:O(nm), SC:O(1)
        int row = grid.length;
        int col = grid[0].length;
        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {
                if (i == row-1 && j == col-1) {
                    grid[i][j] = grid[i][j];
                } else if (i == row - 1) {
                    grid[i][j] += grid[i][j+1];
                } else if (j == col - 1) {
                    grid[i][j] += grid[i+1][j];
                } else {
                    grid[i][j] += Math.min(grid[i][j+1], grid[i+1][j]);
                }
            }
        }
        return grid[0][0];
    }

    private void traversal(int row, int col, int tempsum, int[][] grid) {
        if (row == grid.length || col == grid[0].length) {
            return;
        } else if (row == grid.length-1 && col == grid[0].length-1) {
            tempsum += grid[row][col];
            result = tempsum < result?tempsum:result;
            return;
        }

        tempsum += grid[row][col];
        // Move down
        traversal(row+1, col, tempsum, grid);
        // Move right
        traversal(row, col+1, tempsum, grid);
    }
}