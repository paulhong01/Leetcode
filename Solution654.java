//Leetcode 654: Maximum Binary Tree
import java.util.*;

public class Solution654{
    public static void main(String[] args) {
        int[] nums = {3,2,1,6,0,5};
        Solution654 sol = new Solution654();
        TreeNode root = sol.constructMaximumBinaryTree(nums);
    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        // TC:O(n^2), SC:O(n)
        return traversal(nums, 0, nums.length);
    }

    private TreeNode traversal(int[] nums, int l, int h) {
        if (l == h)
            return null;

        int max_idx = findmax(nums, l, h);
        TreeNode root = new TreeNode(nums[max_idx]);
        root.left = traversal(nums, l, max_idx);
        root.right = traversal(nums, max_idx+1, h);
        return root;
    }

    private int findmax(int[] nums, int l, int h) {
        int temp_max = Integer.MIN_VALUE, idx = -1  ;
        for (int i = l; i < h; i++){
            if (nums[i] > temp_max) {
                temp_max = nums[i];
                idx = i;
            }
        }
        return idx;
    }
} 