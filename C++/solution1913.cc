// Leetcode 1913: Maximum Product Difference Between Two Pairs
#include <iostream>
#include <vector>

namespace {

class Solution {
public:
    int maxProductDifference(std::vector<int>& nums) {
        // TC:O(NlogN), SC:O(1)
        sort(nums.begin(), nums.end());
        int N = nums.size();
        return nums[N-1]*nums[N-2] - nums[0]*nums[1];
    }
};   

} // namesapce
