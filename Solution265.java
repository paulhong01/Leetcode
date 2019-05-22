// Leetcode 265: Paint House II
import java.util.*;

class Solution265 {
    public int minCostII(int[][] costs) {
        // Dynamic Programming, TC:O(NK), SC:O(K), where N = numbers of house, K = numbers of colors
        int N = costs.length;
       
        
        if (N == 0) {
            return 0;
        } else if (N == 1) {
            return findMin(costs[0]);
        }
        int K = costs[0].length;
        int[] prev = new int[K];
        for (int i = 0; i < K; i++) prev[i] = costs[0][i];
        int[] cur = new int[K];
        
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < K; j++) {
                cur[j] = findMinprev(prev, j)+costs[i][j];
            }
            for (int j = 0; j < K; j++) {
                prev[j] = cur[j];
            }
        }
        return findMin(prev);
    }
    
    private int findMinprev(int[] prev, int j) {
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < prev.length; i++) {
            if (i != j) {
                ret = Math.min(ret, prev[i]);
            }
        }
        return ret;
    }
    
    private int findMin(int[] cost) {
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < cost.length; i++) {
            ret = Math.min(ret, cost[i]);
        }
        return ret;
    }
}