// Leetcode 312: Burst Balloons
import java.util.*;

public class Solution312 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        Solution312 sol = new Solution312();
        int res = sol.maxCoins(nums);
        System.out.println(res);
    }

    public int maxCoins(int[] nums) {
        // Method 1: recursively
        int[][] memo = new int[nums.length][nums.length];
        return findMax(nums, 0, nums.length-1, memo);
    }

    private int findMax(int[] nums, int start, int end, int[][] memo) {
        if (start > end) {
            return 0;
        }

        if (memo[start][end] != 0) {
            return memo[start][end];
        }

        int tempmax = Integer.MIN_VALUE;
        for (int i = start; i <= end; i++) {
            int temp = findMax(nums, start, i - 1, memo) + getInt(nums, start - 1)*getInt(nums, i)*getInt(nums, end + 1) + findMax(nums, i + 1, end, memo);
            tempmax = (temp > tempmax)?temp:tempmax;
        }
        memo[start][end] = tempmax;
        return tempmax;
    }

    private int getInt(int[] nums, int idx) {
        if (idx < 0 || idx >= nums.length) {
            return 1;
        } else {
            return nums[idx];
        }
    }
}