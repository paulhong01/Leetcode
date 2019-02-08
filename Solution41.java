// Leetcode 41: First Missing Positive
import java.util.*;

class Solution41 {
    public int firstMissingPositive(int[] nums) {
        // Method 1: TC:O(nlog(n)), SC:O(1)
        // Arrays.sort(nums);
        // int result = 1;
        // for (int n: nums) {
        //     if (n == result) result++;
        //     else if (n > result)    break;
        // }
        // return result;
        
        // Method 2: TC:O(n), SC:O(n)
        // Set<Integer> set = new HashSet();
        // int lastnum = Integer.MIN_VALUE;
        // for (int n: nums) {
        //     lastnum = Math.max(lastnum, n);
        //     set.add(n);
        // }
        // for (int i = 1; i < lastnum; i++) {
        //     if (!set.contains(i))   return i;
        // }
        // return lastnum+1;
        
        // Method 3: TC:O(n), SC:O(1)
        int contain1 = 0;
        for (int n: nums) {
            if (n == 1) {
                contain1++;
                break;
            }
        }
        
        if (contain1 == 0)  return 1;
        if (nums.length == 1)   return 2;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n)    nums[i] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            int a = Math.abs(nums[i]);
            
            if (a == n) nums[0] = - Math.abs(nums[0]);
            else    nums[a] = - Math.abs(nums[a]);
        }
        
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0)    return i;
        }
        return (nums[0] > 0)?n:(n+1);
    }
}