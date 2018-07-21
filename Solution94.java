//Leetcode 94: Binary Tree Inorder Traversal
import java.util.*;

public class Solution94 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution94 sol = new Solution94();
        List<Integer> res = sol.inorderTraversal(root);
        System.out.println(res);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        // Using Stack, TC:O(n), SC:O(n)
        Stack<TreeNode> s = new Stack();
        TreeNode cur = root;
        List<Integer> result = new ArrayList();
        while (cur != null || !s.isEmpty()) {
            while (cur != null) {
                s.push(cur);
                cur = cur.left;
            }

            cur = s.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }
}