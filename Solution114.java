// Leetcode 114: Flatten Binary Tree to Linked List
import java.util.*;

class Solution114 {
    Queue<TreeNode> queue = new LinkedList();
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        // Method 1: TC:O(N), SC:O(N)
        // traversal(root);
        // TreeNode cur = queue.poll();
        // while (!queue.isEmpty()) {
        //     TreeNode next = queue.poll();
        //     cur.right = next;
        //     cur.left = null;
        //     cur = next;
        // }
        // return;
        
        // Method 2: In-place iterative, TC:O(N), SC:O(N)
        // Stack<TreeNode> stack = new Stack();
        // if (root != null)
        //     stack.push(root);
        // while (!stack.isEmpty()) {
        //     TreeNode cur = stack.pop();
        //     if (cur.right != null) {
        //         stack.push(cur.right);
        //     }
        //     if (cur.left != null) {
        //         stack.push(cur.left);
        //     }
        //     cur.right = stack.isEmpty()?null:stack.peek();
        //     cur.left = null;
        // }
        // return;
        
        // Method 3: In-place recursive, 
        if (root == null)   return;
        
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
        return;
    }
    
    
    private void traversal(TreeNode cur) {
        if (cur == null)    return;
        
        queue.add(cur);
        traversal(cur.left);
        traversal(cur.right);
    }
}