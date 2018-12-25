// Leetcode 540: Single Element in a Sorted Array
import java.util.*;

public class Solution540 {

    public static void main(String[] args) {
        Solution540 sol = new Solution540();
        int[] nums = {1, 1, 2, 2, 4, 4, 5, 5,9};
        int res = sol.singleNonDuplicate(nums);
        System.out.println(res);
    }

    public int singleNonDuplicate(int[] nums) {
        // Method 1: Xor, 
        // TC:O(n), SC:O(1)
        // int result = 0;
        // for (int n: nums) {
        //     result = result^n;
        // }
        // return result;

        // Method 2: Binary search
        // TC:O(log(n)), SC:O(1)
        // nums: 1, 2, 2, 3, 3, 4, 4, 8, 8
        // idx: 0, 1, 2, 3, 4, 5, 6, 7, 8
        // m is even: 
        // h[m] == h[m+1] => l = m + 1
        // m is odd:
        // h[m] == h[m-1] => l = m + 1
        // else:
        //     h = m - 1

        // 1, 1, 2, 2, 4, 4, 5, 5, 9
        // 0, 1, 2, 3, 4, 5, 6, 7, 8
        // 1. m = 4 => l = 5
        // 2. m = 6 => l = 7
        // 3. m = 7 => l = 8

        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l)/2;
            if (nums[m] == nums[m+1] && m % 2 == 0)   l = m + 1;
            else if (nums[m] == nums[m-1] && m % 2 == 1) l = m + 1;
            else h = m - 1;
        }
        return nums[l];
        
    }
}