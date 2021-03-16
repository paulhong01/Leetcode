// Leetcode 1785: Minimum Elements to Add to Form a Given Sum
import java.util.*;

class Solution1785 {
    public int minElements(int[] nums, int limit, int goal) {
        // TC:O(N), SC:O(1), where N = nums.length
        long sum = 0;
        for (int num: nums) {
            sum += num;
        }
        
        long gap = Math.abs(goal - sum);
        return (gap%limit == 0)?(int)(gap/limit):(int)(gap/limit+1);
    }
}