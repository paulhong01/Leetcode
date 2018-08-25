// Leetcode 200: Number of Islands
import java.util.*;

public class Solution200 {
    public static void main(String[] args) {
        // char[][] grid = {
        //                 {'1','1','1','1','0'},
        //                 {'1','1','0','1','0'},
        //                 {'1','1','0','0','0'},
        //                 {'0','0','0','0','0'}
        //                 };
        char[][] grid = {};

        Solution200 sol = new Solution200();
        int res = sol.numIslands(grid);
        System.out.println(res);
    }

    private int result = 0;

    public int numIslands(char[][] grid) {
        // DFS: TC:O(m*n), SC:O(m*n), where m = grid.length, n = grid[0].length
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    result++;
                    check(grid, visited, i, j, row, col);
                }
            }
        }
        return result;
    }

    private void check(char[][] grid, boolean[][] visited, int i, int j, int row, int col) {
        if (i >=0 && i < row && j >=0 && j < col && grid[i][j] == '1' && !visited[i][j]) {
            visited[i][j] = true;
            check(grid, visited, i - 1, j, row, col);
            check(grid, visited, i + 1, j, row, col);
            check(grid, visited, i, j - 1, row, col);
            check(grid, visited, i, j + 1, row, col);
        }
    }
}