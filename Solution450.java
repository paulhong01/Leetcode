// Leetcode 450: Delete Node in a BST
import java.util.*;

class Solution450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        } else if (root.val > key) {
            TreeNode leftnode = deleteNode(root.left, key);
            root.left = leftnode;
            return root;
        } else if (root.val < key) {
            TreeNode rightnode = deleteNode(root.right, key);
            root.right = rightnode;
            return root;
        } else {
            if (root.left == null)  return root.right;
            else if (root.right == null)    return root.left;
            root.val = getMin(root.right);
            System.out.println(root.val);
            root.right = deleteNode(root.right, root.val);
            return root;
        }
    }
    
    private int getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}