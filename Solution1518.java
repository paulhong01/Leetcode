// Leetcode 1518: Water Bottles
import java.util.*;

class Solution1518 {
    public int numWaterBottles(int numBottles, int numExchange) {
        // Greedy: TC:O(log(N)), SC:O(1)
        int ret = numBottles, empty = numBottles;
        while (empty >= numExchange) {
            numBottles = empty / numExchange;
            empty %= numExchange;
            ret += numBottles;
            empty += numBottles;
        }
        
        return ret;
    }
}