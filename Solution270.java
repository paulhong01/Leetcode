// Leetcode 270: Closest Binary Search Tree Value
import java.util.*;

class Solution270 {
    public int closestValue(TreeNode root, double target) {
        int closet = root.val;
        double min = Double.MAX_VALUE;
        
        while (root != null) {
            if (Math.abs(root.val - target) < min) {
                min = Math.abs(root.val - target);
                closet = root.val;
            }
            
            if (target < root.val) {
                root = root.left;
            } else if (target > root.val) {
                root = root.right;
            } else {
                return root.val;
            }
        }
        return closet;
    }
}