// Leetcode 268: Missing Number
import java.util.*;

class Solution268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int zero = -1;
        for (int i = 0; i < nums.length; i++) {
            int idx = Math.abs(nums[i]);
            if (idx == n)   continue;

            if (nums[idx] > 0) nums[idx] = -(nums[idx]);
            else if (nums[idx] == 0)    zero = idx;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0 && zero != i)    return i;
        }
        return n;
    }
}