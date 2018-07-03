// Leetcode 101: Symmetric Tree
import java.util.*;

public class Solution101{
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        Solution101 s = new Solution101();
        boolean result = s.isSymmetric(root);
        if (result){
            System.out.println("True");
        } else{
            System.out.println("False");
        }
    }

    public boolean isSymmetric(TreeNode root) {
        // Method 1: Recursive, TC:O(n), SC:O(n)
        /*
        if (root == null)   return true;
        return traversal(root.left, root.right);
        */

        // Method 2: Interative, TC:O(n), SC:O(n)
        if (root == null)   return true;
        Queue<TreeNode> q = new LinkedList();
        q.add(root.right);
        q.add(root.left);
        while (!q.isEmpty()){
            TreeNode nr = q.poll();
            TreeNode nl = q.poll();
            if (nr == null && nl == null)   continue;
            else if (nr == null || nl == null)  return false;
            else if (nr.val != nl.val)  return false;
            else{
                q.add(nr.right);
                q.add(nl.left);
                q.add(nr.left);
                q.add(nl.right);
            }
        }
        return true;
    }

    private boolean traversal(TreeNode l_node, TreeNode r_node){
        if (l_node == null && r_node == null)
            return true;
        else if (l_node == null || r_node == null)
            return false;
        else if (l_node.val != r_node.val)
            return false;
        else{
            return traversal(l_node.left, r_node.right)&&traversal(l_node.right, r_node.left);
        }
    }
}