// Leetcode 238: Product of Array Except Self
import java.util.*;

public class Solution238{
    public static void main(String[] args){
        //int[] nums = {1, 2, 3, 4};
        int[] nums = {2, 3, 4, 5};
        Solution238 s = new Solution238();
        int[] result = s.productExceptSelf(nums);
        for (int i: result){
            System.out.printf("%d ", i);
        }
        System.out.println("");
    }

    public int[] productExceptSelf(int[] nums) {
        // Divide the multiplication into two part, one is from the left, the other is from the right, both exclude the current element
        // TC: O(N), SC: O(1)
        int[] result = new int[nums.length];
        result[0] = 1;
        // from left
        for (int i = 1; i < nums.length; i++){
            result[i] = result[i-1] * nums[i-1];
        }
        
        // from right
        int temp = nums[nums.length - 1];
        for (int i = nums.length-2; i >= 0; i--){
            result[i] *= temp;
            temp *= nums[i];
        }
        return result;
    }
}