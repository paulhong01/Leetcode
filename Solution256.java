// Leetcode 256: Paint House
import java.util.*;

class Solution256 {
    public int minCost(int[][] costs) {
        // TC:O(N), SC:O(1)
        int N = costs.length;
        int[][] dp = new int[N][3];
        int[] prev = new int[3];
        int[] cur = new int[3];
        
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return retMin(costs[0]);
        }
        
        prev[0] = costs[0][0];
        prev[1] = costs[0][1];
        prev[2] = costs[0][2];
                
        for (int i = 1; i < N; i++) {
            cur[0] = Math.min(prev[1], prev[2])+costs[i][0];
            cur[1] = Math.min(prev[0], prev[2])+costs[i][1];
            cur[2] = Math.min(prev[0], prev[1])+costs[i][2];
            
            prev[0] = cur[0];
            prev[1] = cur[1];
            prev[2] = cur[2];
        }
        
        return retMin(prev);      
        
    }
    
    private int retMin(int[] costs) {
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ret = Math.min(ret, costs[i]);
        }
        return ret;
    }
    
}