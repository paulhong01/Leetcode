// Leetcode 98: Validate Binary Search Tree
import java.util.*;

class Solution98 {
    boolean firstnum = true;
    long prev = Integer.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        // Method 1: Recursive, TC:O(N), SC:O(N)
        // if (root == null)   return true;
        
        // if (!isValidBST(root.left)) return false;
        // if (firstnum) {
        //     firstnum = false;
        //     prev = root.val;
        // } else if (prev >= root.val) {
        //     return false;
        // }
        // prev = root.val;
        // return isValidBST(root.right);

        // Method 2: Iterative, TC:O(N), SC:O(N)
        List<Integer> list = new ArrayList();
        Stack<TreeNode> stack = new Stack();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }
        
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) <= list.get(i-1))   return false;
        }
        return true;
    }
}