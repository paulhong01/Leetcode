// Leetcode 283: Move Zeroes
import java.util.*;

public class Solution283{
    public static void main(String args[]){
        int []nums = {0,1,0,3,12};
        Solution283 s = new Solution283();
        s.moveZeroes(nums);
        for (int i: nums) System.out.printf("%d ", i);
        System.out.println("");
    }

    public void moveZeroes(int[] nums) {
        // TC: O(N), SC: O(1), where N = nums.length
        int index = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0)
                nums[index++] = nums[i];
        }

        while (index < nums.length){
            nums[index++] = 0;
        }
    }
}