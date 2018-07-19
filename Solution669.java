//Leetcode 669: Trim a Binary Search Tree
import java.util.*;

public class Solution669 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        Solution669 sol = new Solution669();
        int L = 1, R = 3;
        TreeNode res = sol.trimBST(root, L, R);
        sol.showresult(res);
        System.out.println("");
    }

    public void showresult(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        System.out.println(root.val);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            if (cur != null)
                System.out.printf("%d ", cur.val);
            else    
                System.out.printf("%s ", "null");

            if (cur.right != null) {
                q.add(cur.left);
                q.add(cur.right);
            } else if (cur.left != null) {
                q.add(cur.left);
            }
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        // TC:O(N), SC:O(H), where N = number of elements in tree, H = the height of the tree
        if (root == null) {
            return null;
        } else if  (root.val < L) {
            return trimBST(root.right, L, R);
        } else if (root.val > R) {
            return trimBST(root.left, L, R);
        } else {
            root.left = trimBST(root.left, L, R);
            root.right = trimBST(root.right, L, R);
            return root;
        }
    }
}