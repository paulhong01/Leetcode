//Leetcode 617: Merge Two Binary Trees
import java.util.*;

public class Solution617{
    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);

        TreeNode t2 = new TreeNode(2);
        t2.right = new TreeNode(3);
        t2.right.right = new TreeNode(7);
        t2.left = new TreeNode(1);
        t2.left.right = new TreeNode(4);
        
        Solution617 sol = new Solution617();
        TreeNode res = sol.mergeTrees(t1, t2);
        sol.preorder(res);
        System.out.println("");
    }

    public void preorder(TreeNode cur) {
        if (cur == null)    return;

        preorder(cur.left);
        System.out.printf("%d ", cur.val);
        preorder(cur.right);
    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // TC:O(n), SC:O(h), where n = total number of nodes, h = the height of the tree
        if (t1 == null || t2 == null) {
            return (t1 == null)?t2:t1;
        }

        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        t1.val = t1.val + t2.val;
        return t1;
    }
}