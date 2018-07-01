// Leetcode 695: Max Area of Island
import java.util.*;

public class Solution695{
    public static void main(String[] args){
        int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,1,1,0,1,0,0,0,0,0,0,0,0},
                        {0,1,0,0,1,1,0,0,1,0,1,0,0},
                        {0,1,0,0,1,1,0,0,1,1,1,0,0},
                        {0,0,0,0,0,0,0,0,0,0,1,0,0},
                        {0,0,0,0,0,0,0,1,1,1,0,0,0},
                        {0,0,0,0,0,0,0,1,1,0,0,0,0}
                       };
        Solution695 s = new Solution695();
        int result = s.maxAreaOfIsland(grid);
        System.out.println(Integer.toString(result));
    }

    public int maxAreaOfIsland(int[][] grid) {
        // Use DFS: TC:O(N), SC:O(N), where N = number of elements of grid
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                int temp = checker(grid, visited, i ,j);
                max = temp>max?temp:max;
            }
        }
        return max;
    }

    private int checker(int[][] grid, boolean[][] visited, int x, int y){
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || visited[x][y])
            return 0;
        
        visited[x][y] = true;
        return 1 + checker(grid, visited, x-1, y) + checker(grid, visited, x+1, y) + checker(grid, visited, x, y-1) + checker(grid, visited, x, y+1);
    }
}