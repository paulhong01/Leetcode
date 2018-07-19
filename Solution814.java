//Leetcode 814: Binary Tree Pruning
import java.util.*;

public class Solution814{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(0);
        root.right.right = new TreeNode(1);
        Solution814 sol = new Solution814();
    }

    public TreeNode pruneTree(TreeNode root) {
        // TC:O(N), SC:O(H), where N is the number of nodes in the tree, H is the height of the tree.
        boolean leftroot = traversal(root.left);
        boolean rightroot = traversal(root.right);
        if (root.val == 0) {
            if (leftroot && rightroot) {
                return null;
            } else {
                root = (leftroot)?root.right:root.left;
                return root;
            }
        } else {
            root.left = (leftroot)?null:root.left;
            root.right = (rightroot)?null:root.right;
            return root;
        }
    }

    private boolean traversal(TreeNode cur) {
        if (cur == null) {
            return true;
        }

        boolean leftcur = traversal(cur.left);
        boolean rightcur = traversal(cur.right);
        cur.left = (leftcur)?null:cur.left;
        cur.right = (rightcur)?null:cur.right;
        return (leftcur && rightcur && cur.val == 0);
    }
}