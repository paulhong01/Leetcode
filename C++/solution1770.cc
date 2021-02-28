// Leetcode 1770: Maximum Score from Performing Multiplication Operations
#include <iostream>
#include <vector>

namespace {
class Solution {
    public:
        int n, m;
        int memo[1000][1000];
        int maximumScore(std::vector<int>& nums, std::vector<int>& multipliers) {
            n = nums.size();
            m = multipliers.size();
            memset(memo, -1, sizeof(memo));
            return dp(0, 0, nums, multipliers);
        }
        
        int dp(int l, int i, const std::vector<int>& nums, const std::vector<int>& multipliers) {
            if (i == m) return 0;
            if (memo[l][i] != -1)   return memo[l][i];
            int pickLeft = dp(l+1, i+1, nums, multipliers) + nums[l]*multipliers[i];
            int pickRight = dp(l, i+1, nums, multipliers) + nums[n - (i-l) - 1] * multipliers[i];
            memo[l][i] = max(pickLeft, pickRight);
            return memo[l][i];
        }
    };
} // namespace
