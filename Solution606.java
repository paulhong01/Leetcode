//Leetcode 606: Construct String from Binary Tree
import java.util.*;

public class Solution606 {
    private StringBuilder result = new StringBuilder();
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);

        Solution606 sol = new Solution606();
        String res = sol.tree2str(root);
        System.out.println(res);
    }

    public String tree2str(TreeNode t) {
        if (t == null)
            return result.toString();
        
        traversal(t);
        return result.toString();
    }

    private void traversal(TreeNode cur) {
        if (cur == null) {
            return;
        }

        result.append(Integer.toString(cur.val));
        // left subtree
        if (cur.left != null || cur.right != null) {
            result.append("(");
            traversal(cur.left);
            result.append(")");

            // right subtree
            if (cur.right != null) {
                result.append("(");
                traversal(cur.right);
                result.append(")");
            } 
        } 

    }
}