// Leetcode 2826: Sorting Three Groups

class Solution2826 {
    public int minimumOperations(List<Integer> nums) {
        // TC:O(N^2), SC:O(N)
        int N = nums.size();
        int longest_non_decreasing = 1;
        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < nums.size(); i++) {
            int cur_max = 0;
            for (int j = 0; j < i; j++) {
                if (nums.get(i) >= nums.get(j)) {
                    cur_max = Math.max(cur_max, dp[j]);
                }
            }
            dp[i] = cur_max+1;
            longest_non_decreasing = Math.max(longest_non_decreasing, dp[i]);
        }
        return N - longest_non_decreasing;
    }
}