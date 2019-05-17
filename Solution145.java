// Leetcode 145: Binary Tree Postorder Traversal
import java.util.*;

class Solution145 {
    List<Integer> result = new ArrayList();
    public List<Integer> postorderTraversal(TreeNode root) {
        // Method 1: Recursive: TC:O(N), SC:O(N)
        // traversal(root);

        // Method 2: Iterative: TC:O(N), SC:O(N)
        Stack<TreeNode> stack = new Stack();
        if (root != null)   stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            result.add(cur.val);
            if (cur.left != null)   stack.push(cur.left);
            if (cur.right != null)  stack.push(cur.right);
        }
        Collections.reverse(result);
        return result;
    }
    
    private void traversal(TreeNode cur) {
        if (cur == null)    return;
        traversal(cur.left);
        traversal(cur.right);
        result.add(cur.val);
    }
}