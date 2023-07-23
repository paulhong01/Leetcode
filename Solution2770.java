// Leetcode 2770: Maximum Number of Jumps to Reach the Last Index

class Solution2770 {
    public int maximumJumps(int[] nums, int target) {
        // TC:O(N^2), SC:O(N)
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(nums[i] - nums[j]) <= target && dp[j] != -1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[nums.length - 1] == 0?-1:dp[nums.length-1];
    }
}
