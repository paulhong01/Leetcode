// Leetcode 958: Check Completeness of a Binary Tree
import java.util.*;

class Solution958 {
    public boolean isCompleteTree(TreeNode root) {
        // Method 1: One pass
//         Queue<TreeNode> queue = new LinkedList();
//         if (root != null)   queue.add(root);
//         boolean leftcheck = true;
//         boolean rightcheck = true;
//         while (!queue.isEmpty()) {
//             int size = queue.size();
            
//             for (int i = 0; i < size; i++) {
//                 TreeNode cur = queue.poll();
//                 if (cur.left != null) {
//                     if (!leftcheck || !rightcheck)  return false;
//                     else queue.add(cur.left);
//                 } else {
//                     leftcheck = false;
//                 }
                
//                 if (cur.right != null) {
//                     if (!leftcheck || !rightcheck) return false;
//                     else queue.add(cur.right);
//                 } else {
//                     rightcheck = false;
//                 }
//             }
//         }
//         return true;
        
        // Method 2: Two pass
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (queue.peek() != null) {
            TreeNode cur = queue.poll();
            queue.add(cur.left);
            queue.add(cur.right);
        }
        
        while (!queue.isEmpty() && queue.peek() == null) {
            queue.poll();
        }
        return queue.isEmpty();
    }
}