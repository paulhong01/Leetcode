// Leetcode 27: Remove Element
import java.util.*;

public class Solution27 {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
    }

    public int removeElement(int[] nums, int val) {
        // Use a index "count" to find the position for replacement.
        // TC:O(n), SC:O(1)
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) count++;
            else nums[i - count] = nums[i];
        }   
        return nums.length - count;
    }
}