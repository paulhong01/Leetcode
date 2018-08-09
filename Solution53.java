// Leetcode 53: Maximum Subarray
import java.util.*;

public class Solution53 {
    public static void main(String[] args) {
        // int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums = {-1, -2, -3};

        Solution53 sol = new Solution53();
        int res = sol.maxSubArray(nums);
        System.out.println(res);

    }

    public int maxSubArray(int[] nums) {
        // Method 1: Brute Force, TC:O(n^2), SC:O(1)
        /* int maxvalue = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp > maxvalue) {
                    maxvalue = temp;
                }
            }
        }
        return maxvalue; */

        // Method 2: Dynamic programming, TC:O(n), SC:O(1)
        int prevstate = nums[0]; // state is the maximum sum of subset which includes nums[i]
        int maxvalue = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int state = prevstate + nums[i] > nums[i]? (prevstate + nums[i]):nums[i];
            if (state > maxvalue) {
                maxvalue = state;
            }
            prevstate = state;
        }

        return maxvalue;



    }
} 