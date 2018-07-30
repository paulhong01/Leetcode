// Leetcode 543: Diameter of Binary Tree
import java.util.*;

public class Solution543 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        Solution543 sol = new Solution543();
        int result = sol.diameterOfBinaryTree(root);
        System.out.println(result);
    }

    int tempmax = Integer.MIN_VALUE;

    public int diameterOfBinaryTree(TreeNode root) {
        // TC:O(n), SC:O(n)
        int height = helper(root);
        int maxpath = Math.max(tempmax, height) - 1; // Minus one since the problem is asking about number of path not nodes
        return (maxpath)<0?0:maxpath; 
    }

    // helper is a dfs function
    private int helper(TreeNode cur) {
        if (cur == null) {
            return 0;
        } else if (cur.left == null && cur.right == null) {
            return 1;
        }

        int templeft = helper(cur.left);
        int tempright = helper(cur.right);
        int tempdiameter = templeft + tempright + 1;
        if ( tempdiameter > tempmax) {
            tempmax = tempdiameter;
        }

        // return height
        return Math.max(templeft, tempright) + 1;
    }
}