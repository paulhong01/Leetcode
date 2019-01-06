// Leetcode 965: Univalued Binary Tree
import java.util.*;

class Solution965 {
    public boolean isUnivalTree(TreeNode root) {
        if (root == null)   return true;
        
        int value = root.val;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.val != value)   return false;
            if (cur.right != null)  queue.add(cur.right);
            if (cur.left != null)   queue.add(cur.left);
        }
        return true;
    }
}