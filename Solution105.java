// Leetcode 105: Construct Binary Tree from Preorder and Inorder Traversal
import java.util.*;

public class Solution105 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        Solution105 sol = new Solution105();
        TreeNode resroot = sol.buildTree(preorder, inorder);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // TC:O(n), SC:O(n)
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traversal(0, 0, preorder.length - 1, preorder, inorder, map);
    }

    private TreeNode traversal(int prestart, int instart, int inend, int[] preorder, int[] inorder, Map<Integer, Integer> map) {
        if(prestart >= preorder.length || inend < instart)  return null;

        TreeNode root = new TreeNode(preorder[prestart]);
        int inindex = map.get(root.val);        

        root.left = traversal(prestart + 1, instart, inindex - 1, preorder, inorder, map);
        root.right = traversal(prestart + inindex - instart + 1, inindex + 1, inend, preorder, inorder, map);

        return root;
    }
}