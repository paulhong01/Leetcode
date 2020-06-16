// Leetcode 1464: Maximum Product of Two Elements in an Array
import java.util.*;

class Solution1464 {
    public int maxProduct(int[] nums) {
        // TC:O(N), SC:O(1)
        int first = Math.max(nums[0], nums[1]);
        int second = Math.min(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > first) {
                second = first;
                first = nums[i];
            } else if (nums[i] > second) {
                second = nums[i];
            }
        }
        return (first-1)*(second-1);
    }
}