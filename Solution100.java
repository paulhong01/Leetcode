//Leetcode 100 : Same Tree
import java.util.*;

public class Solution100 {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        
        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(3);

        Solution100 sol = new Solution100();
        boolean result = sol.isSameTree(p, q);
        if (result) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Method 1 : Iterative, TC:O(n), SC:O(m), where m = maximum number of elements in any layer
        // Queue<TreeNode> pq = new LinkedList();
        // Queue<TreeNode> qq = new LinkedList();
        // if (p == null && q == null)
        //     return true;
        // else if (p == null || q == null)
        //     return false;
        // else {
        //     pq.add(p);
        //     qq.add(q);
        // }

        // while (!pq.isEmpty() && !qq.isEmpty()) {
        //     TreeNode curp = pq.poll(), curq = qq.poll();
        //     if (curp.val != curq.val) {
        //         return false;
        //     }

        //     if (curp.left != null && curq.left != null) {
        //         pq.add(curp.left);
        //         qq.add(curq.left);
        //     } else if ((curp.left == null || curq.left == null) && !(curp.left == null && curq.left == null)) {
        //         return false;
        //     } 

        //     if (curp.right != null && curq.right != null) {
        //         pq.add(curp.right);
        //         qq.add(curq.right);
        //     } else if ((curp.right == null || curq.right == null) && !(curp.right == null && curq.right == null)) {
        //         return false;
        //     } 
        // }

        // return true;
        

        // Method 2: Recursive
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return (p.val == q.val) && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }
}