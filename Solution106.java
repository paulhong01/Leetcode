// Leetcode 106: Construct Binary Tree from Inorder and Postorder Traversal
import java.util.*;

public class Solution106 {
    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        Solution106 sol = new Solution106();
        TreeNode resroot = sol.buildTree(inorder, postorder);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // TC:O(n), SC:O(n)
        Map<Integer, Integer> inmap = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            inmap.put(inorder[i], i);
        }
        return traversal(postorder, inorder, postorder.length - 1, 0, inorder.length - 1, inmap);
    }

    private TreeNode traversal(int[] postorder, int[] inorder, int postidx, int instart, int inend, Map<Integer, Integer> inmap) {
        if (postorder.length == 0 || postidx < 0 || instart > inend)    return null;

        TreeNode root = new TreeNode(postorder[postidx]);
        int inidx = inmap.get(root.val);

        root.right = traversal(postorder, inorder, postidx - 1, inidx + 1, inend, inmap);
        root.left = traversal(postorder, inorder, postidx - inend + inidx - 1, instart, inidx - 1, inmap);

        return root;
    }
}