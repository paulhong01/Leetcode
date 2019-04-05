// Leetcode 120: Triangle
import java.util.*;

class Solution120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // Method 1: TC:O(N), SC:O(N)
        /*
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[][] dp = new int[m][n];
        for (int i = 0; i < triangle.get(0).size(); i++) {
            dp[0][i] = triangle.get(0).get(i);
        }
        
        for (int i = 1; i < m; i++) {
            int prevsize = triangle.get(i-1).size();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int prevleft = (j-1 >= 0)?dp[i-1][j-1]:Integer.MAX_VALUE;
                int prevright = (j >= prevsize)?Integer.MAX_VALUE:dp[i-1][j];
                dp[i][j] = triangle.get(i).get(j) + Math.min(prevleft, prevright);
            }
        }
        
        int result = dp[m-1][0];
        for (int i = 1; i < n; i++) {
            result = Math.min(result, dp[m-1][i]);
        }
        return result;
        */
        
        // Method 2: TC:(N), SC:(n), where N = total number of lists, n = max numbers of rows
        int m = triangle.size();
        int n = triangle.get(m-1).size();
        int[] prev = new int[n];
        int[] cur = new int[n];
        for (int i = 0; i < triangle.get(0).size(); i++) {
            prev[i] = triangle.get(0).get(i);
        }
        for (int i = 1; i < m; i++) {
            int prevsize = triangle.get(i-1).size();
            for (int j = 0; j < triangle.get(i).size(); j++) {
                int prevleft = (j-1>=0)?prev[j-1]:Integer.MAX_VALUE;
                int prevright = (j >= prevsize)?Integer.MAX_VALUE:prev[j];
                // System.out.printf("%d %d %d %d\n", i, j, prevleft, prevright);
                cur[j] = triangle.get(i).get(j) + Math.min(prevleft, prevright);
                // System.out.printf("%d %d %d\n", i, j, cur[j]);
            }
            for (int j = 0; j < n; j++)
                prev[j] = cur[j];
            // prev = cur;
        }
        int result = prev[0];
        for (int i = 1; i < n; i++) {
            result = Math.min(result, prev[i]);
        }
        return result;
    }
}