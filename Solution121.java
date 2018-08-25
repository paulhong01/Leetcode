// Leetcode 121: Best Time to Buy and Sell Stock
import java.util.*;

public class Solution121 {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};

        Solution121 sol = new Solution121();
        int res = sol.maxProfit(prices);
        System.out.println(res);
    }

    public int maxProfit(int[] prices) {
        // Method 1: Brute Force, TC:O(n^2), SC:O(1)
        /* int profit = 0;
        for (int buyidx = 0; buyidx < prices.length - 1; buyidx++) {
            for (int sellidx = buyidx + 1; sellidx < prices.length; sellidx++) {
                if (prices[sellidx] - prices[buyidx] > profit) {
                    profit = prices[sellidx] - prices[buyidx];
                }
            }
        }
        return profit; */

        // Method 2: One pass,
        int lowprice = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < lowprice) {
                lowprice = prices[i];
            } else {
                int temp = prices[i] - lowprice;
                profit = (temp > profit)?temp:profit;
            }
        }
        return profit;
    }
}