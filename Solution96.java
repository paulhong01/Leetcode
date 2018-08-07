// Leetcode 96: Unique Binary Search Trees
import java.util.*;

public class Solution96 {
    public static void main(String[] args) {
        int n = 3;

        Solution96 sol = new Solution96();
        int res = sol.numTrees(n);
        System.out.println(res);
    }

    public int numTrees(int n) {
        // Dynamic Programming, TC:O(n^2), SC:O(n)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int level = 2; level <= n; level++) {
            for (int root = 1; root <= level; root++) {
                dp[level] += dp[root - 1]*dp[level - root];
            }
        }
        return dp[n];
    }
}