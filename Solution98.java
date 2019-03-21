// Leetcode 98: Validate Binary Search Tree
import java.util.*;

class Solution98 {
    boolean firstnum = true;
    long prev = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null)   return true;
        
        if (!isValidBST(root.left)) return false;
        if (firstnum) {
            firstnum = false;
            prev = root.val;
        } else if (prev >= root.val) {
            return false;
        }
        prev = root.val;
        return isValidBST(root.right);
    }
}