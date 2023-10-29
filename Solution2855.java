// Leetcode 2855: Minimum Right Shifts to Sort the Array

import java.util.List;

class Solution2855 {
    public int minimumRightShifts(List<Integer> nums) {
        // TC:O(N), SC:O(1)
        int non_sorted_idx = -1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) >= nums.get(i-1)) {
                continue;
            }
            if (non_sorted_idx == -1) {
                non_sorted_idx = i;
            } else {
                return -1;
            }
        }
        if (non_sorted_idx == -1) {
            return 0;
        } else if (nums.get(nums.size()-1) <= nums.get(0)) {
            return nums.size()-non_sorted_idx;
        } 
        return -1;
    }
}
