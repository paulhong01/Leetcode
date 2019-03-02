// Leetcode 285: Inorder Successor in BST
import java.util.*;

class Solution285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode leftnode = inorderSuccessor(root.left, p);
            return leftnode == null?root:leftnode;
        }
    }
}
