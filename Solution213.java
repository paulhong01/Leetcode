// Leetcode 213: House Robber II
import java.util.*;

class Solution213 {
    public static void main(String[] args) {
        int[] nums = {2, 3, 2};
        Solution213 sol = new Solution213();
        int res = sol.rob(nums);
        System.out.println(res);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)  return 0;
        else if (nums.length == 1)  return nums[0];
        
        int n = nums.length;
        return Math.max(helper(nums, 0, n-2), helper(nums, 1, n-1));
    }
    
    private int helper(int[] nums, int l, int h) {
        int cur = 0, prev = 0, prev2 = 0;
        for (int i = l; i <= h; i++) {
            cur = Math.max(prev2 + nums[i], prev);
            prev2 = prev;
            prev = cur;
        }
        return cur;
    }
}