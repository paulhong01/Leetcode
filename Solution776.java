// Leetcode 776: Split BST
import java.util.*;

class Solution776 {
    public TreeNode[] splitBST(TreeNode root, int V) {
        if (root == null) {
            return new TreeNode[]{null, null};
        }
        
        if (root.val > V) {
            TreeNode[] childret = splitBST(root.left, V);
            root.left = childret[1];
            return new TreeNode[]{childret[0], root};
        } else {
            TreeNode[] childret = splitBST(root.right, V);
            root.right = childret[0];
            return new TreeNode[]{root, childret[1]};
        }
    }
}