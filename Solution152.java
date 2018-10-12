// Leetcode 152: Maximum Product Subarray
import java.util.*;

public class Solution152 {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};

        Solution152 sol = new Solution152();
        int res = sol.maxProduct(nums);
        System.out.println(res);
    }

    public int maxProduct(int[] nums) {
        // Method 1: Brute force: TC:O(n^2), SC:O(1)
        int maxresult = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            maxresult = (nums[i] > maxresult)?nums[i]:maxresult; 
            for (int j = i + 1; j < nums.length; j++) {
                temp *= nums[j];
                maxresult = (temp > maxresult)?temp:maxresult;
            }
        }
        return maxresult;

    }   
}