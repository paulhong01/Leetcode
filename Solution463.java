//Leetcode 463: Island Perimeter
import java.util.*;

public class Solution463{
    public static void main(String[] args){
        int[][] grid = {{0,1,0,0},
                        {1,1,1,0},
                        {0,1,0,0},
                        {1,1,0,0}
                        };
        Solution463 sol = new Solution463();
        int result = sol.islandPerimeter(grid);
        System.out.println(result);
    }

    public int islandPerimeter(int[][] grid) {
        // TC:O(mn), SC:O(1), where m = grid.length, n = grid[0].length
        int count = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    count += 4;
                    if (i > 0 && grid[i-1][j] == 1) count -= 2;
                    if (j > 0 && grid[i][j-1] == 1) count -= 2;
                }
            }
        }
        return count;
    }
}