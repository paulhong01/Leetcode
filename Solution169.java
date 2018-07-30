// Leetcode 169 : Majority Element
import java.util.*;

public class Solution169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};

        Solution169 sol = new Solution169();
        int result = sol.majorityElement(nums);
        System.out.println(result);
    }

    public int majorityElement(int[] nums) {
        // TC:O(n), SC:O(1)
        // Initialize a key and a count, 
        // key is for the majority element, and count is the count that the majority element appear
        int key = nums[0];
        int count = 1;
        
        // Iteratively search for the next element
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == key) {
                count++;
            } else if (count -1 == 0){
                key = nums[i];
                count = 1;
            } else {
                count--;
            }
        }

        return key;
    }
}