// Leetcode 545:  Boundary of Binary Tree
import java.util.*;

class Solution545 {
    List<Integer> ret = new ArrayList();
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        if (root == null)   return ret;
        
        ret.add(root.val);
        leftBoundary(root.left);
        leaveNode(root.left);
        leaveNode(root.right);
        rightBoundary(root.right);
        return ret;
    }
    
    private void leftBoundary(TreeNode cur) {
        if (cur == null || (cur.left == null && cur.right == null)) return;
        
        ret.add(cur.val);
        if (cur.left == null) {
            leftBoundary(cur.right);
        } else {
            leftBoundary(cur.left);
        }
    }
    
    private void rightBoundary(TreeNode cur) {
        if (cur == null || (cur.left == null && cur.right == null)) return;
        
        if (cur.right == null) {
            rightBoundary(cur.left);
        } else {
            rightBoundary(cur.right);
        }
        ret.add(cur.val);
    }
    
    private void leaveNode(TreeNode cur) {
        if (cur == null)    return;
        
        if (cur.left == null && cur.right == null) {
            ret.add(cur.val);
            return;
        }
        
        leaveNode(cur.left);
        leaveNode(cur.right);
    }
}