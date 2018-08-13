// Leetcode 198: House Robber
import java.util.*;

public class Solution198 {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        // int[] nums = {8, 1, 1, 3};
        // int[] nums = {2, 1};

        Solution198 sol = new Solution198();
        int res = sol.rob(nums);
        System.out.println(res);
    }

    public int rob(int[] nums) {
        // Dynamic Programming, TC:O(n), SC:O(1)
        int size = nums.length;
        if (size == 0) {
            return 0;
        } else if (size == 1) {
            return nums[0];
        } else if (size == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int front = nums[0];
        int second = Math.max(front, nums[1]);
        int cur = 0;
        for (int i = 2; i < size; i++) {
            cur = Math.max(front + nums[i], second);
            front = second;
            second = cur;
        }

        return cur;

    }
}