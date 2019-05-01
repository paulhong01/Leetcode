// Leetcode 153: Find Minimum in Rotated Sorted Array
import java.util.*;

class Solution153 {
    public int findMin(int[] nums) {
        // TC:O(N), SC:O(1)
        // int result = Integer.MAX_VALUE;
        // for (int n: nums) {
        //     result = n < result?n:result;
        // }
        // return result;
        
        // Binary Search, TC:O(log(n)), SC:O(1) 
        if (nums.length == 1) {
            return nums[0]; 
        } 
        int l = 0, h = nums.length-1;
        while (l <= h) {
            int m = l + (h-l)/2;
           
            if ((m == nums.length -1 || nums[m]<nums[m+1]) && (m == 0 || nums[m-1] > nums[m])) {
                return nums[m];
            } else if (nums[m] > nums[h]) {
                l = m+1;
            } else {
                h = m-1;
            }
        }
        return -1;
    }
}