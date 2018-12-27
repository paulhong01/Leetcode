// Leetcode 220: Contains Duplicate III
import java.util.*;

class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // Method 1: Brute force
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = 1; j <= k; j++) {
        //         if (i + j >= nums.length) break;
        //         if (Math.abs((long)nums[i] - (long)nums[i+j]) <= t) return true;
        //     }
        // }
        // return false;
        
        // Method 2: Binary Search Tree
        // TC:O(nlog(k)), SC:O(k)
//         if (nums == null ||  nums.length == 0 || k <= 0 || t < 0) return false;
        
//         TreeSet<Integer> set = new TreeSet();
//         for (int i = 0; i < nums.length; i++) {
//            // the smallest number larger than nums[i]
//             Integer ceil = set.ceiling(nums[i]);
//             if (ceil != null && Long.valueOf(ceil) - Long.valueOf(nums[i]) <= t)    return true;
            
//             // the largest number smaller than nums[i]
//             Integer floor = set.floor(nums[i]);
//             if (floor != null && Long.valueOf(nums[i]) - Long.valueOf(floor) <= t)  return true;
            
//             set.add(nums[i]);
//             if (i >= k) set.remove(nums[i-k]);
//         }
//         return false;
        
        // Method 3: Bucket
        // TC:O(n), SC:O(k)
        if (nums == null || nums.length == 0 || k <= 0 || t < 0) return false;
        
        int minvalue = Integer.MAX_VALUE;
        for (int n: nums) {
            minvalue = Math.min(minvalue, n);
        }
        
        HashMap<Long, Integer> bucket = new HashMap();
        long diff = Long.valueOf(t) + 1;
        
        for (int i = 0; i < nums.length; i++) {
            long index = (Long.valueOf(nums[i]) - Long.valueOf(minvalue))/diff;
            // Check left adjacent bucket
            Integer left_bucket = bucket.get(index - 1);
            if (left_bucket != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(left_bucket)) <= t)  return true;
            
            // Check right adjacent bucket
            Integer right_bucket = bucket.get(index + 1);
            if (right_bucket != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(right_bucket)) <= t)    return true;
            
            // Check current bucket
            Integer current_bucket = bucket.get(index);
            if (current_bucket != null && Math.abs(Long.valueOf(nums[i]) - Long.valueOf(current_bucket)) <= t) return true;
            
            bucket.put(index, nums[i]);
            if (i >= k) {
                bucket.remove((Long.valueOf(nums[i - k]) - Long.valueOf(minvalue))/diff);
            }
        }
        return false;
        
    }
}