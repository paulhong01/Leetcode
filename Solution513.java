//Leetcode 513 : Find Bottom Left Tree Value
import java.util.*;

public class Solution513 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);

        Solution513 sol = new Solution513();
        int res = sol.findBottomLeftValue(root);
        System.out.println(res);
    }

    int result = -1, layer = 0;
    public int findBottomLeftValue(TreeNode root) {
        // Method 1: Interatively using queue, TC:O(n), SC:O(n)
        // Queue<TreeNode> q = new LinkedList();
        // q.add(root);
        // int result = 0;
        // while (!q.isEmpty()) {
        //     TreeNode cur = q.poll();
        //     if (cur.right != null)  q.add(cur.right);
        //     if (cur.left != null)   q.add(cur.left);
        //     result = cur.val;
        // }
        // return result;

        // Method 2: DFS, TC:O(n), SC:O(h), where h = the height of tree
        helper(root, 1);
        return result;
    }

    private void helper(TreeNode cur, int depth) {
        if (layer < depth) {
            layer = depth;
            result = cur.val;
        }

        if (cur.left != null) helper(cur.left, depth+1);
        if (cur.right != null) helper(cur.right, depth+1);
    }
}