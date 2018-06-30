//Leetcode 485: Max Consecutive Ones
import java.util.*;

public class Solution485{
    public static void main(String[] args){
        int[] nums = {1,1,0,1,1,1};
        Solution485 s = new Solution485();
        int result = s.findMaxConsecutiveOnes(nums);
        System.out.println(Integer.toString(result));
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        // TC:O(N), SC:O(1)
        int max = 0, sum = 0;
        for (int i = 0; i < nums.length; i++){
            sum = (sum + 1)*nums[i];
            max = (sum > max)?sum:max;
        }
        return max;
    }
}