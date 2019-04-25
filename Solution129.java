// Leetcode 129: Sum Root to Leaf Numbers
import java.util.*;

class Solution129 {
    long result = 0;
    public int sumNumbers(TreeNode root) {
        // TC:O(N), SC:O(N)
        traversal(root, 0);
        return (int)result;
    }
    
    private void traversal(TreeNode cur, long sum) {
        if (cur == null) {
            return;
        } else if (cur.left == null && cur.right == null) {
            result += sum*10 + cur.val;
            return;
        }
        
        traversal(cur.left, sum*10+cur.val);
        traversal(cur.right, sum*10+cur.val);
    }
}