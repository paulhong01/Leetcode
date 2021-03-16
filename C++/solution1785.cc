// Leetcode 1785: Minimum Elements to Add to Form a Given Sum
#include <iostream>
#include <vector>

namespace {
class Solution {
public:
    int minElements(std::vector<int>& nums, int limit, int goal) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        long gap = abs(goal - sum);
        return (gap%limit == 0)?(gap/limit):(gap/limit+1);
    }
};
} // namespace
