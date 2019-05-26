// Leetcode 163: Missing Ranges
import java.util.*;

class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // TC:O(N), SC:O(1)
        int idx = 0;
        while (idx < nums.length && nums[idx] < lower) idx++;
        
        List<String> result = new ArrayList();
        long left = lower;
        while (idx < nums.length && nums[idx] <= upper) {
            long cur = nums[idx++];
            long right = cur -1 ;
            
            if (left == right) {
                result.add(String.valueOf(left));
            } else if (left < right) {
                result.add(String.valueOf(left) + "->" + String.valueOf(right));
            }
            
            left = cur + 1;
        }
        
        if (left == upper) {
            result.add(String.valueOf(left));
        } else if (left < upper) {
            result.add(String.valueOf(left) + "->" + String.valueOf(upper));
        }
        return result;
    }
}