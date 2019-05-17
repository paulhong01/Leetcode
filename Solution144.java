// Leetcode 144: Binary Tree Preorder Traversal
import java.util.*;

class Solution144 {
    List<Integer> result = new ArrayList();
    public List<Integer> preorderTraversal(TreeNode root) {
        // Method 1: Recursive: TC:O(N), SC:O(N)
        // traversal(root);

        // Method 2: Iterative: TC:O(N), SC:O(N)
        Stack<TreeNode> stack = new Stack();
        if (root != null) stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.right != null)  stack.push(cur.right);
            if (cur.left != null) stack.push(cur.left);
        }
        return result;
    }
    
    private void traversal(TreeNode cur) {
        if (cur == null)    return;
        result.add(cur.val);
        traversal(cur.left);
        // result.add(cur.val);
        traversal(cur.right);
    }
}