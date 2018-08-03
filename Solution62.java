// Leetcode 62: Unique Paths
import java.util.*;

public class Solution62 {
    public static void main(String[] args) {
        int m = 7, n = 3;

        Solution62 sol = new Solution62();
        int res = sol.uniquePaths(m, n);
        System.out.println(res);
    }

    public int uniquePaths(int m, int n) {
        // Dynamic Programming, TC:O(mn), SC:O(mn)
        int[][] dp = new int[n][m];
        Arrays.fill(dp[0], 1);
        
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] += (j >= 1)?dp[i][j - 1]:0; // Move right
                dp[i][j] += (i >= 1)?dp[i - 1][j]:0; // Move down
            }
        }

        return dp[n-1][m-1];
    }
}