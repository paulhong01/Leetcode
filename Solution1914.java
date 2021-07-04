// Leetcode 1914: Cyclically Rotating a Grid
import java.util.*;

class Solution1914 {
    public int[][] rotateGrid(int[][] grid, int k) {
        // TC:O(NM), SC:O(1)
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0;i<m/2 && i < n/2;++i) {
            int cnt = k % ((m-1-2*i + n-1-2*i)*2); // % by total number of elements in this layer
            while (cnt-- > 0) {
                int tmp = grid[i][i];
                for (int j=i;j<n-1-i;++j) grid[i][j]=grid[i][j+1];
                for (int j=i;j<m-1-i;++j) grid[j][n-1-i]=grid[j+1][n-1-i];
                for (int j=n-1-i;j>i;--j) grid[m-1-i][j]=grid[m-1-i][j-1];
                for (int j=m-1-i;j>i;--j) grid[j][i]=grid[j-1][i];
                grid[i+1][i]=tmp;
            }
        }
        return grid;
    }
}