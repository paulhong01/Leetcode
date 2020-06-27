// Leetcode 99: Recover Binary Search Tree
import java.util.*;

class Solution99 {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prev = null;
    public void recoverTree(TreeNode root) {
        traversal(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    public void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }
        
        traversal(cur.left);
        if (prev != null && first == null && prev.val > cur.val) {
            first = prev;
        }
        
        if (prev != null && first != null && prev.val > cur.val) {
            second = cur;
        }
        
        prev = cur;
        traversal(cur.right);
    }
}