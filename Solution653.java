//Leetcode 653: Two Sum IV - Input is a BST
import java.util.*;

public class Solution653 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(6);
        root.right.right = new TreeNode(7);
        int target = 6;

        Solution653 sol = new Solution653();
        boolean res = sol.findTarget(root, target);
        if (res)
            System.out.println("True");
        else   
            System.out.println("False");
    }

    public boolean findTarget(TreeNode root, int k) {
        // TC:O(n), SC:O(n)
        Queue<TreeNode> q = new LinkedList();
        Set<Integer> s = new HashSet();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (s.contains(cur.val)) {
                return true;
            } else {
                s.add(k - cur.val);
            }
            
            if (cur.left != null) {
                q.add(cur.left);
            }
            
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        return false;
    }

}