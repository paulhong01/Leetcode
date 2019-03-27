// Leetcode 122: Best Time to Buy and Sell Stock II
import java.util.*;

class Solution122 {
    public int maxProfit(int[] prices) {
        int buy = Integer.MAX_VALUE, profit = 0, sell = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buy) {
                buy = prices[i];
            } else if (prices[i] >= sell) {
                sell = prices[i];
                if (i == prices.length-1 || prices[i+1] < sell) {
                    profit += (sell - buy);
                    buy = Integer.MAX_VALUE;
                    sell = Integer.MIN_VALUE;
                }
            } else if (i == prices.length-1 && sell > buy) {
                profit += (sell - buy);
            }
        }
        return profit;
        
    }
}