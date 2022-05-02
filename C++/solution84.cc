// Leetcode 84: Largest Rectangle in Histogram
#include <iostream>
#include <stack>
#include <vector>

namespace {
class Solution {
public:
    int largestRectangleArea(vector<int>& heights) {
        // TC:O(N), SC:O(N)
        stack<int> target_idx_stack;
        target_idx_stack.push(-1);
        int ret = 0;
        for (int i = 0; i < heights.size(); i++) {
            while (target_idx_stack.top() != -1 && heights[i] < heights[target_idx_stack.top()]) {
                int target_height = heights[target_idx_stack.top()];
                target_idx_stack.pop();
                ret = max(ret, target_height*(i - target_idx_stack.top() - 1));
            }
            target_idx_stack.push(i);
        }
        while (target_idx_stack.top() != -1) {
            int target_height = heights[target_idx_stack.top()];
            target_idx_stack.pop();
            int temp = target_height*(heights.size() - target_idx_stack.top() - 1);
            ret = max(ret, temp);
        }
        return ret;
    }
};
}   // namespace