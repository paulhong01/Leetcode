// Leetcode 63: Unique Paths II
import java.util.*;

class Solution63 {
    // OPT(i, j): number of ways from (i, j) to (m-1, n-1)
    // OPT(m-1, n-1) = 1
    // OPT(i, j) = 0, if obstacleGrid[i][j] = 1
    // OPT(i, j) = OPT(i+1, j) + OPT(i,j+1), otherwise
    // ANS: OPT(0, 0)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // DP: TC:O(m*n), SC:O(m*n)
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] OPT = new int[m][n];
        
        if (obstacleGrid[m-1][n-1] == 1)    return 0;
        
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (i == m-1 && j == n-1) {
                    OPT[i][j] = 1;
                } else if (obstacleGrid[i][j] == 1) {
                    OPT[i][j] = 0;
                } else {
                    if (i+1 < m) {
                        OPT[i][j] += OPT[i+1][j];
                    }
                    
                    if (j+1 < n) {
                        OPT[i][j] += OPT[i][j+1];
                    }
                }
            }
        }
        return OPT[0][0];
    }
}