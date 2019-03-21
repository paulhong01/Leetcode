// Leetcode 72: Edit Distance
import java.util.*;

class Solution72 {
    public int minDistance(String word1, String word2) {
        // Dynamic programming, TC:O(nm), SC:O(nm), where n = word1.length(), m = word2.length()
        int n1 = word1.length(), n2 = word2.length();
        int[][] dp = new int[n1+1][n2+1];
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n2; i++) {
            dp[0][i] = i;
        }
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        return dp[n1][n2];
    }
}