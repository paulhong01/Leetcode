// Leetcode 1770: Maximum Score from Performing Multiplication Operations
import java.util.*;

class Solution1770 {
    int n, m;
    int[][] memo;
    public int maximumScore(int[] nums, int[] multipliers) {
        // TC:O(M^2), SC:O(M^2)
        n = nums.length;
        m = multipliers.length;
        memo = new int[m][m];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(memo[i], -1);
        }
        return dp(0, 0, nums, multipliers);
    }
    
    private int dp(int l, int i, int[] nums, int[] multipliers) {
        if (i == m) return 0;
        if (memo[l][i] != -1)   return memo[l][i];
        int pickLeft = dp(l+1, i+1, nums, multipliers) + nums[l] * multipliers[i];
        int pickRight = dp(l, i+1, nums, multipliers) + nums[n - (i-l) - 1]*multipliers[i];
        memo[l][i] = Math.max(pickLeft, pickRight);
        return memo[l][i];
    }
}