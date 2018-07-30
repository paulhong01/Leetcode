// Leetcode 494: Target Sum
import java.util.*;

public class Solution494 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3; 

        Solution494 sol = new Solution494();
        int res = sol.findTargetSumWays(nums, S);
        System.out.println(res);
    }

    private int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        // Method 1: Backtracking, TC:O(2^n), SC:O(n)
        // helper(nums, 0, 0, S);
        // return result;

        // Method 2: Dynamic Programming, TC:O(n*l), SC:O(l), where l = the range of sum possible.
        int count = 0;
        for (int i: nums) {
            count += i;
        }
        if (S > count || S < -count)    return 0;
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] = 1;
        for (int i = 1; i < nums.length; i++) {
            int[] next = new int[2001];
            for (int sum = -1000; sum < 1000; sum++){
                if (dp[sum + 1000] > 0) {
                    next[sum + 1000 + nums[i]] += dp[sum + 1000];
                    next[sum + 1000 - nums[i]] += dp[sum + 1000];
                }
            }
            dp = next;
        }
        return dp[S+1000];
    }

    private void helper(int[] nums, int pos, int cursum, int S) {
        if (pos == nums.length) {
            if (cursum == S) {
                result++;
            }
            return;
        }

        helper(nums, pos+1, cursum+nums[pos], S);
        helper(nums, pos+1, cursum-nums[pos], S);
    }
}