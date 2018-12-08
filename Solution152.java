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
        // int maxresult = nums[0];
        // for (int i = 0; i < nums.length; i++) {
        //     int temp = nums[i];
        //     maxresult = (nums[i] > maxresult)?nums[i]:maxresult; 
        //     for (int j = i + 1; j < nums.length; j++) {
        //         temp *= nums[j];
        //         maxresult = (temp > maxresult)?temp:maxresult;
        //     }
        // }
        // return maxresult;

        // Method 2: Dynamic Programming
        // TC:O(n), SC:O(n)
        // OPTMAX(i): largest product subarray that start from i
        // OPTMIN(i): smallest product subarray that start from i
        // base case: OPTMAX(n) = OPTMIN(i) = nums[n]
        // nums[i] >=0:
        //     OPTMAX(i) = max(nums[i], OPTMAX(i+1)*nums[i])
        //     OPTMIN(i) = min(nums[i], OPTMIN(i+1)*nums[i])
        // nums[i] < 0:
        //     OPTMAX(i) = max(nums[i], OPTMIN(i+1)*nums[i])
        //     OPTMIN(i) = min(nums[i], OPTMAX(i+1)*nums[i])
        int[] OPTMAX = new int[nums.length];
        int[] OPTMIN = new int[nums.length];
        Arrays.fill(OPTMAX, Integer.MIN_VALUE);
        Arrays.fill(OPTMIN, Integer.MAX_VALUE);
        OPTMAX[nums.length-1] = nums[nums.length-1];
        OPTMIN[nums.length-1] = nums[nums.length-1];
            
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= 0) {
                OPTMAX[i] = Math.max(nums[i], OPTMAX[i+1]*nums[i]);
                OPTMIN[i] = Math.min(nums[i], OPTMIN[i+1]*nums[i]);
            } else {
                OPTMAX[i] = Math.max(nums[i], OPTMIN[i+1]*nums[i]);
                OPTMIN[i] = Math.min(nums[i], OPTMAX[i+1]*nums[i]);
            }
        }
        
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, OPTMAX[i]);
        }
        return result;
    }   
}