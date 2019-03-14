// Leetcode 1008: Construct Binary Search Tree from Preorder Traversal
import java.util.*;

class Solution1008 {
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        // Method 1
//         TreeNode root = new TreeNode(preorder[0]);
        
//         Stack<TreeNode> s = new Stack<TreeNode>();
//         s.push(root);
        
//         for (int i = 1; i < preorder.length; i++) {
//             TreeNode temp = null;
            
            
//             while (!s.isEmpty() && preorder[i] > s.peek().val) {
//                 temp = s.pop();
//             }
            
//             if (temp != null) {
//                 temp.right = new TreeNode(preorder[i]);
//                 s.push(temp.right);
//             } else {
//                 temp = s.peek();
//                 temp.left = new TreeNode(preorder[i]);
//                 s.push(temp.left);
//             }
//         }
//         return root;
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }
    
    private TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound)  return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }
}