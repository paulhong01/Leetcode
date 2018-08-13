// Leetcode 572: Subtree of Another Tree
import java.util.*;

public class Solution572 {
    public static void main(String[] args) {
        // TreeNode s = new TreeNode(3);
        // s.left = new TreeNode(4);
        // s.right = new TreeNode(5);
        // s.left.left = new TreeNode(1);
        // s.left.right = new TreeNode(2);
        // s.left.right.left = new TreeNode(0);

        // TreeNode t = new TreeNode(4);
        // t.left = new TreeNode(1);
        // t.right = new TreeNode(2);

        TreeNode s = new TreeNode(1);
        s.left = new TreeNode(1);

        TreeNode t = new TreeNode(1);

        Solution572 sol = new Solution572();
        boolean res = sol.isSubtree(s, t);
        if (res) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean isSubtree(TreeNode s, TreeNode t) {
        // TC:O(m*n), SC:O(n)
        return (s != null)&&(equals(s, t)||isSubtree(s.left, t)||isSubtree(s.right, t));
    }

    private boolean equals(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        return (s.val == t.val)&&equals(s.left, t.left)&&equals(s.right, t.right);
    }

    
}