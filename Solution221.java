// Leetcode 221: Maximal Square
import java.util.*;

class Solution221 {
    public int maximalSquare(char[][] matrix) {
        // DP: TC:O(MN), SC:O(MN)
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int result = 0;
        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                if (matrix[i][j] == '0') {
                    dp[i][j] = 0;
                } else {
                    if ((i < m-1 && matrix[i+1][j] == '1') && (j < n-1 && matrix[i][j+1] == '1')) {
                        dp[i][j] = Math.min(dp[i+1][j], Math.min(dp[i+1][j+1], dp[i][j+1]))+1;
                    } else {
                        dp[i][j] = 1;
                    }
                    result = Math.max(result, dp[i][j]*dp[i][j]);
                }
            }
        }
        return result;
    }
}