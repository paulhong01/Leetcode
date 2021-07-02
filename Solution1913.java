// Leetcode 1913: Maximum Product Difference Between Two Pairs
import java.util.*;

class Solution {
    public int maxProductDifference(int[] nums) {
        // TC:O(NlogN), SC:O(1)
        Arrays.sort(nums);
        int N = nums.length;
        return nums[N-1]*nums[N-2] - nums[0]*nums[1];
    }
}