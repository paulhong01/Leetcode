// Leetcode 136: Single Number
import java.util.*;

public class Solution136{
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        Solution136 sol = new Solution136();
        int result = sol.singleNumber(nums);
        System.out.println(result);
    }

    public int singleNumber(int[] nums) {
        // TC:O(n), SC:O(1)
        int res = nums[0];
        for (int i = 1; i < nums.length; i++){
            res ^= nums[i];
        }
        return res;
    }
}