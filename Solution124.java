// Leetcode 124: Binary Tree Maximum Path Sum
import java.util.*;

class Solution124 {
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traversal(root);
        return result;
    }
    
    private int traversal(TreeNode cur) {
        if(cur == null) return 0;
        
        int leftval = traversal(cur.left);
        int rightval = traversal(cur.right);
        int tempresult = Math.max(cur.val, Math.max(cur.val+leftval, Math.max(cur.val+rightval, cur.val+rightval+leftval)));
        result = Math.max(result, tempresult);
        return Math.max(cur.val, Math.max(leftval, rightval)+cur.val);
    }
}