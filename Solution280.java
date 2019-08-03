// Leetcode 280: Wiggle Sort
import java.util.*;

class Solution280 {
    public void wiggleSort(int[] nums) {
        boolean less = true;
        for (int i = 0; i < nums.length-1; i++) {
            if (less) {
                if (nums[i] > nums[i+1]) {
                    swap(nums, i, i+1);
                }
            } else {
                if (nums[i] < nums[i+1]) {
                    swap(nums, i, i+1);
                }
            }
            less = !less;
        }
    }
    
    private void swap(int[] nums, int idx1, int idx2) {
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}