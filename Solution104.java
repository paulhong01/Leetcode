//Leetcode 104: Maximum Depth of Binary Tree
import java.util.*;

public class Solution104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution104 sol = new Solution104();
        int result = sol.maxDepth(root);
        System.out.println(result);
    }

    public int maxDepth(TreeNode root) {
        // Method 1: BFS, Queue, TC:(n), SC:O(m)
        // n = number of nodes in tree, m = maximum number of nodes in any layer
        // Queue<TreeNode> q = new LinkedList();
        // if (root != null)
        //     q.add(root);
        // int count = 0;
        // while (!q.isEmpty()) {
        //     int size = q.size();
        //     count++;
        //     for (int i = 0; i < size; i++) {
        //         TreeNode cur = q.poll();
        //         if (cur.left != null)   q.add(cur.left);
        //         if (cur.right != null)  q.add(cur.right);
        //     }
        // }
        // return count;

        // Method 2: DFS, TC:O(n), SC:O(h), where h = the height of the tree
        if (root == null)
            return 0;
        
        int leftlength = maxDepth(root.left);
        int rightlength = maxDepth(root.right);
        return Math.max(leftlength+1, rightlength+1);

    }
}