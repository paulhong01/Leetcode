// Leetcode 530: Minimum Absolute Difference in BST
import java.util.*;

class Solution530 {
    int result = Integer.MAX_VALUE;
    int prev = Integer.MIN_VALUE;
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
    }
    
    private void traversal(TreeNode cur) {
        if (cur == null)    return;
        
        traversal(cur.left);
        if (prev != Integer.MIN_VALUE) {
            result = Math.min(result, cur.val - prev);
        }
        prev = cur.val;
        traversal(cur.right);
    }
}