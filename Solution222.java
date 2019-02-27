// Leetcode 222: Count Complete Tree Nodes
import java.util.*;

class Solution222 {
    public int countNodes(TreeNode root) {
        // BFS, TC:O(n), SC:O(n)
        /*
        int result = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        
        while (!queue.isEmpty()) {
            result++;
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.add(cur.left);
            }
            if (cur.right != null) {
                queue.add(cur.right);
            }
        }
        return result;*/
        
        // Recursively, TC:O(log(n)*log(n)), SC:O(log(n)*log(n))
        if (root == null)   return 0;
        
        int hl = 0, hr = 0;
        TreeNode l = root, r = root;
        while (l != null) {
            hl++;
            l = l.left;
        }
        while (r != null) {
            hr++;
            r = r.right;
        }
        if (hr == hl)   return (int)Math.pow(2, hl)-1;
        
        return 1 + countNodes(root.left) + countNodes(root.right);
        
    }
}