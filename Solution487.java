// Leetcode 487: Max Consecutive Ones II
import java.util.*;

class Solution487 {
    public int findMaxConsecutiveOnes(int[] nums) {
        // Method 1: TC:O(n^2), SC:O(1)
        // int result = 0;
        // for (int i = 0; i < nums.length; i++) {
        //     boolean flag = false;
        //     int j = i;
        //     for (j = i; j < nums.length; j++) {
        //         if (nums[j] == 0) {
        //             if (flag)   break;
        //             flag = true;
        //         }
        //     }
        //     result = Math.max(j-i, result);
        // }
        // return result;
        
        // Method 2: TC:O(n), SC:O(1)
        // List<Integer> zeros = new ArrayList<>();
        // zeros.add(-1);
        // for (int i = 0; i < nums.length; i++) {
        //     if (nums[i] == 0) {
        //         zeros.add(i);
        //     }
        // }
        // if (zeros.size() <= 2) {
        //     return nums.length;
        // }
        // int result = 0;
        // for (int i = 2; i < zeros.size(); i++) {
        //     result = Math.max(result, zeros.get(i) - zeros.get(i-2) - 1);
        // }
        // result = Math.max(result, nums.length - zeros.get(zeros.size()-2) - 1);
        // return result;
        
        // Method 3: Sliding windows: TC:O(n), SC:O(1)
        int result = 0, zero = 0, k = 1;
        for (int l = 0, h = 0; h < nums.length; h++) {
            if (nums[h] == 0)   zero++;
            
            while (zero > k) {
                if (nums[l++] == 0)
                    zero--;
            }
            result = Math.max(result, h - l + 1);
        }
        return result;
    }
}