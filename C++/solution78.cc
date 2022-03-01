// Leetcode 78: Subsets
#include <iostream>
#include <vector>

namespace {
class Solution {
public:
    std::vector<std::vector<int>> subsets(std::vector<int>& nums) {
        std::vector<std::vector<int>> ret;
        std::vector<int> cur;
        backtracking(ret, cur, 0, nums);
        return ret;
    }
    
    void backtracking(std::vector<std::vector<int>>& ret, std::vector<int>& cur, int start_idx, std::vector<int>& nums) {
        ret.push_back(std::vector<int>(cur));
        
        for (int i = start_idx; i < nums.size(); i++) {
            cur.push_back(nums[i]);
            backtracking(ret, cur, i+1, nums);
            cur.pop_back();
        }
    }
};

}   // namespace
