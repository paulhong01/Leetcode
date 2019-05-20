// Leetcode 128: Longest Consecutive Sequence
import java.util.*;

class Solution128 {
    public int longestConsecutive(int[] nums) {
        // Method 1: Sorting, TC:O(nlog(n)), SC:O(1)
        // if (nums.length == 0)   return 0;
        // Arrays.sort(nums);
        // int result = 1;
        // int cur = 1;
        // for (int i = 1; i < nums.length; i++) {
        //     if (nums[i] == nums[i-1]+1) {
        //         cur++;
        //         result = Math.max(result, cur);
        //     } else if (nums[i] == nums[i-1]) {
        //         continue;
        //     } else {
        //         cur = 1;
        //     }
        // }
        // return result;

        // Method 2: TC:O(N), SC:O(N)
        Set<Integer> set = new HashSet();
        for (int n: nums)   set.add(n);
        
        int result = 0;
        for (int n: nums) {
            if (!set.contains(n-1)) {
                int cur = n;
                int curlength = 1;
                while (set.contains(cur+1)) {
                    cur++;
                    curlength++;
                }
                result = Math.max(result, curlength);
            }
        }
        return result;
    }
}