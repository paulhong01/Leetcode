//Leetcode 226: Invert Binary Tree
import java.util.*;

public class Solution226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        Solution226 sol = new Solution226();
        TreeNode res = sol.invertTree(root);
    }

    public TreeNode invertTree(TreeNode root) {
        // Method 1 : BFS, TC:O(n), SC:O(m), 
        // n = number of nodes in the tree, m = maximun number in any layer
        // Queue<TreeNode> q = new LinkedList();
        // if (root != null)
        //     q.add(root);
        // while (!q.isEmpty()) {
        //     TreeNode cur = q.poll();
        //     TreeNode temp = cur.left;
        //     cur.left = cur.right;
        //     cur.right = temp;
        //     if (cur.left != null)   q.add(cur.left);
        //     if (cur.right != null)  q.add(cur.right);
        // }
        // return root;

        // Method 2 : Recursively, TC:O(n), SC:O(h), where h = the height of the tree
        if (root == null) 
            return null;
        
        TreeNode templeft = invertTree(root.left);
        TreeNode tempright = invertTree(root.right);
        root.left = tempright;
        root.right = templeft;
        return root;
    }
}