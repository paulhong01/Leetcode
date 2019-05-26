// Leetcode 162: Find Peak Element
import java.util.*;

class Solution162 {
    public int findPeakElement(int[] nums) {
        // Binary search: TC:O(log(n)), SC:O(1)
        int l = 0, r = nums.length-1;
        while (l <= r) {
            int m = l + (r-l)/2;
            
            if ((m == 0 || nums[m] > nums[m-1]) && (m==nums.length-1 || nums[m] > nums[m+1])) {
                return m;               
            } else if (nums[m] < nums[m+1]) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return -1;
        
        // Linear search: TC:O(N), SC:O(1)
        // int N = nums.length;
        // for (int i = 0; i < N; i++) {
        //     if ((i == 0 || nums[i] > nums[i-1]) && (i == N-1 || nums[i] > nums[i+1])) {
        //         return i;
        //     }
        // }
        // return -1;
    }
}