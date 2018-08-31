// Leetcode 108: Convert Sorted Array to Binary Search Tree
import java.util.*;

public class Solution108 {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};

        Solution108 sol = new Solution108();
        TreeNode resroot = sol.sortedArrayToBST(nums);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        // TC:O(n), SC:O(n)
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r || l < 0 || r >= nums.length)  return null;

        int m = (l + r) / 2;
        TreeNode root = new TreeNode(nums[m]);
        root.left = helper(nums, l, m-1);
        root.right = helper(nums, m+1, r);
        return root;
    }
}