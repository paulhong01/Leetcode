// Leetcode 1920: Build Array from Permutation
#include <iostream>
#include <vector>

namespace {
class Solution1920 {
public:
    std::vector<int> buildArray(std::vector<int>& nums) {
        // TC:O(N), SC:O(N)
        int N = nums.size();
        std::vector<int> ans(N, 0);
        for (int i = 0; i < N; ++i) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
};    
}
