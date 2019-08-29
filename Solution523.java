// Leetcode 523: Continuous Subarray Sum
import java.util.*;

class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        // Method 1: Brute Force, TC:O(N^2), SC:O(1)
        // for (int i = 0; i < nums.length; i++) {
        //     int cur_sum = nums[i];
        //     for (int j = i+1; j < nums.length; j++) {
        //         cur_sum += nums[j];
        //         if (cur_sum % k == 0)   return true;
        //     }
        // }
        // return false;
        
        // Prefix sum, TC:O(N), SC:O(N)
        int sum = 0;
        HashMap < Integer, Integer > map = new HashMap < > ();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0)
                sum = sum % k;
            if (map.containsKey(sum)) {
                if (i - map.get(sum) > 1)
                    return true;
            } else
                map.put(sum, i);
        }
        return false;
    }
}