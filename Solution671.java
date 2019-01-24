// Leetcode 671: Second Minimum Node In a Binary Tree
import java.util.*;

class Solution671 {
    int min, min2;
    public int findSecondMinimumValue(TreeNode root) {
        min = Integer.MAX_VALUE;
        min2 = Integer.MAX_VALUE;
        traversal(root);
        return min2 == Integer.MAX_VALUE?-1:min2;
    }
    
    private void traversal(TreeNode cur) {
        if (cur == null)    return;
        
        traversal(cur.left);
        if (cur.val < min) {
            min2 = min;
            min = cur.val;
        } else if (cur.val < min2 && cur.val != min) {
            min2 = cur.val;
        }
        traversal(cur.right);
    }
}