// Leetcode 236: Lowest Common Ancestor of a Binary Tree
import java.util.*;

class Solution236 {
    TreeNode result = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversal(root, p, q);
        return result;        
    }
    
    private boolean[] traversal(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)   return new boolean[2];
        
        boolean[] left_ret = traversal(root.left, p, q);
        boolean[] right_ret = traversal(root.right, p, q);
        boolean[] response = new boolean[2];
        response[0] = (root == p)|left_ret[0]|right_ret[0];
        response[1] = (root == q)|left_ret[1]|right_ret[1];
        if (result == null && response[0] && response[1]) {
            result = root;
        }
        return response;
    }
}