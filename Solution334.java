// Leetcode 334: Increasing Triplet Subsequence
import java.util.*;

class Solution334 {
    // OPT(i): longest common subsequence until i
        
    public boolean increasingTriplet(int[] nums) {
        // Method 1: Dynamic programming brute force
        // OPT(i): longest common subsequence until i
        // TC:O(n^2), SC:O(n)
        // if (nums.length < 3)    return false;
        
        // int[] dp = new int[nums.length];
        // dp[0] = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     int maxval = 0;
        //     for (int j = 0; j < i; j++) {
        //         if (nums[j] < nums[i]) maxval = Math.max(maxval, dp[j]);
        //     } 
        //     dp[i] = maxval + 1;
        //     if (dp[i] >= 3) return true;
        // }
        // return false;

        // Method 2: Dynamic programming with binary search
        // TC:O(n), SC:O(1)
        if (nums == null || nums.length == 0) { return false; }
        
        int firstMin = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        
        for (int i=0; i<nums.length; i++) {
            if (nums[i] <= firstMin) {
                firstMin = nums[i];
            } else if (nums[i] < secondMin && secondMin > firstMin) {
                secondMin = nums[i];
            }  else if (nums[i] > firstMin && nums[i] > secondMin) {
                return true;
            }               
        }
        return false;
    }
}