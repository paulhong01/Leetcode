// Leetcode 1339: Maximum Product of Splitted Binary Tree
import java.util.*;

class Solution1339 {
    long total = 0, ret = 0, sub;
    public int maxProduct(TreeNode root) {
        // TC:O(N), SC:O(height)
        // Get the total sum
        total = s(root);
        // Find the biggest product
        s(root);
        return (int)(ret % (int)(1e9+7));
    }
    
    public int s(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        sub = root.val + s(root.left) + s(root.right);
        ret = Math.max(ret, sub * (total - sub));
        return (int)sub;
    } 
}
