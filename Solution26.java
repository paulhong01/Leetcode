// Leetcode 26: Remove Duplicates from Sorted Array
import java.util.*;

class Solution26 {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n: nums) {
            if (i < 1 || n > nums[i-1]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}