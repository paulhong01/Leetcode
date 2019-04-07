// Leetcode 1022: Sum of Root To Leaf Binary Numbers
import java.util.*;

class Solution1022 {
    long result = 0;
    int mod = (int)(Math.pow(10, 9)) + 7;
    public int sumRootToLeaf(TreeNode root) {
        System.out.println(mod);
        traversal(root, 0);
        return (int)result;
    }
    
    private void traversal(TreeNode cur, long cursum) {
        if (cur == null)    return;
        else if (cur.left == null && cur.right == null) {
            result = (result+cursum+cur.val)%mod;
            return;
        }
        
        cursum = (cursum+cur.val)%mod;
        traversal(cur.left, cursum*2);
        traversal(cur.right, cursum*2);
    }
    
}