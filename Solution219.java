// Leetcode 219: Contains Duplicate II
import java.util.*;


class Solution219 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int k = 3;
        Solution219 sol = new Solution219();
        if (sol.containsNearbyDuplicate(nums, k)) System.out.println("True");
        else System.out.println("False");
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Method 1: Brute force
        // TC:O(n*k), SC:O(k)
        // Set<Integer> set = new HashSet();
        // for (int i = 0; i < nums.length; i++) {
        //     set.clear();
        //     set.add(nums[i]);
        //     for (int j = 1; j <= k; j++) {
        //         if (i + j >= nums.length) {
        //             break;
        //         } else if (set.contains(nums[i+j])) {
        //             return true;
        //         } else {
        //             set.add(nums[i+j]);
        //         }
        //     }
        // }
        // return false;
        
        // Method 2: Sliding windows       
        // TC:O(n), SC:O(k)
        Set<Integer> set = new HashSet();
        int tempsize = Math.min(k, nums.length);
        for (int i = 0; i < tempsize; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        
        for (int i = k; i < nums.length; i++) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            set.remove(nums[i-k]);
        }
        
        return false;
        
        
        
    }
}