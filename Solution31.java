// Leetcode 31: Next Permutation
import java.util.*;

public class Solution31 {
    public static void main(String[] args) {
        int[] nums = {1, 1, 5};

        Solution31 sol = new Solution31();
        sol.nextPermutation(nums);
        for (int n: nums) {
            System.out.printf("%d ", n);
        }
        System.out.println("");
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >=0 && nums[i] > nums[i + 1]) i--;

        if (i >= 0) {
            int switchidx = nums.length - 1;
            while (nums[switchidx] <= nums[i] && switchidx >= 0) switchidx--;
            swap(nums, i, switchidx);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int l) {
        int r = nums.length - 1;
        while (l < r) {
            swap(nums, l, r);
            l++;
            r--;
        }
    }
    private void swap(int[] nums, int i1, int i2) {
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}