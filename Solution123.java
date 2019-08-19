// Leetcode 123: Best Time to Buy and Sell Stock III
import java.util.*;

class Solution123 {
    public int maxProfit(int[] prices) {
        // Method 1: 
        // int maxprofit = 0;
        // for (int i = 1; i < prices.length; i++) {
        //     int profit = findProfit(0, i, prices) + findProfit(i+1, prices.length-1, prices);
        //     maxprofit = Math.max(maxprofit, profit);
        // }
        // return maxprofit;
        
        // Method 2: Dynamic Programming, TC:O(KN), SC:O(KN)
        if (prices.length == 0) return 0;
        int[][] dp = new int[3][prices.length];
        
        for (int k = 1; k <= 2; k++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[k-1][i-1]);
                dp[k][i] = Math.max(dp[k][i-1], prices[i] - min);
            }
        }
        return dp[2][prices.length-1];
    }
    
    private int findProfit(int l, int r, int[] prices) {
        if (l >= r) return 0;
        int buy = Integer.MAX_VALUE, sell = Integer.MIN_VALUE;
        int maxprofit = 0;
        for (int i = l; i <= r; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] > buy) {
                maxprofit = Math.max(maxprofit, prices[i] - buy);
            }
        }
        return maxprofit;
    }
} 