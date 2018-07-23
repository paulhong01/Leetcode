//Leetcode 538: Convert BST to Greater Tree
import java.util.*;

public class Solution538 {
    private int sum = 0;
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);

        Solution538 sol = new Solution538();
        root = sol.convertBST(root);
        sol.inorder(root);

    }

    public void inorder(TreeNode cur) {
        if (cur == null) {
            return;
        }

        inorder(cur.left);
        System.out.printf("%d ", cur.val);
        inorder(cur.right);
    }

    public TreeNode convertBST(TreeNode root) {
        // Method 1: Iteratively, TC:O(n), SC:O(m), where m = maximum number in layer
        // TreeNode cur = root;
        // Stack<TreeNode> stack = new Stack();
        // while (cur != null || !stack.isEmpty()) {
        //     while (cur != null) {
        //         stack.push(cur);
        //         cur = cur.right;
        //     } 
        //     cur = stack.pop();
        //     sum += cur.val;
        //     cur.val = sum;
        //     cur = cur.left;
        // }
        // return root;

        // Method 2: Recursively, TC:O(n), SC:O(h), where h = height of the tree
        helper(root);
        return root;
    }

    private void helper(TreeNode cur) {
        if (cur == null) {
            return;
        }

        helper(cur.right);
        sum += cur.val;
        cur.val = sum;
        helper(cur.left);
    }
}