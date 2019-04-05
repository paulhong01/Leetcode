// Leetcode 209: Minimum Size Subarray Sum
import java.util.*;

class Solution209 {
    public int minSubArrayLen(int s, int[] nums) {
        // 1. cursum < s => update cursum => rightpointer++
        // 2. else => update result => update cursum => leftpointer++
        // stop when rightpointer == nums.length
        // if result == Integer.MAX_VALUE => return 0, else return result
        // Sliding windows: TC:O(n), SC:O(1)
        int result = Integer.MAX_VALUE;
        int cursum = 0;
        int leftpointer = 0, rightpointer = 0;
        while (rightpointer < nums.length || cursum >= s) {
            if (cursum < s) {
                cursum += nums[rightpointer++];
            } else {
                result = Math.min(rightpointer-leftpointer, result);
                cursum -= nums[leftpointer++];
            }
        }
        return result == Integer.MAX_VALUE?0:result;
    }
}