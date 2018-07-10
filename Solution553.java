// Leetcode 553: Optimal Division
import java.util.*;

public class Solution553{
    public static void main(String[] args){
        int[] nums = {1000,100,10,2};
        Solution553 sol = new Solution553();
        String result = sol.optimalDivision(nums);
        System.out.println(result);
    }

    public String optimalDivision(int[] nums) {
        // TC:O(n), SC:O(n), where n = number of character in nums
        if (nums.length == 1){
            return Integer.toString(nums[0]);
        } else if (nums.length == 2){
            return Integer.toString(nums[0]) + "/" + Integer.toString(nums[1]);
        } else{
            String result = Integer.toString(nums[0])+"/(";
            for (int i = 1; i < nums.length-1; i++){
                result += Integer.toString(nums[i]) + "/";
            }
            result += Integer.toString(nums[nums.length-1]) + ")";
            return result;
        }
    }
}