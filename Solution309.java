// Leetcode 309: Best Time to Buy and Sell Stock with Cooldown
import java.util.*;

public class Solution309 {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        
        Solution309 sol = new Solution309();
        int res = sol.maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        // Dynamic programming, TC:O(n), SC:O(1)
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price: prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
}