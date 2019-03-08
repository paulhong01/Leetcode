// Leetcode 59: Spiral Matrix II
import java.util.*;

class Solution59 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        
        int idx = 1, cur = 0;
        
        while (idx <= n*n) {
            // Right
            for (int i = cur; i < (n-cur); i++) {
                result[cur][i] = idx++;
            }
            
            // Down
            for (int i = cur+1; i < (n-cur); i++) {
                result[i][n-cur-1] = idx++;
            }

            
            // Left
            for (int i = n-cur-2; i >= cur; i--) {
                result[n-cur-1][i] = idx++;
            }

            
            // Up
            for (int i = n-cur-2; i >= (cur+1); i--) {
                result[i][cur] = idx++;
            }

            cur++;
        }
        return result;
    }
}