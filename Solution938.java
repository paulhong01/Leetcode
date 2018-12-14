class Solution938 {
    int result = 0;
    
    public int rangeSumBST(TreeNode root, int L, int R) {
        // Treat binary search tree as sorted array by doing inorder traversal
        // TC:(n), SC:O(1)
        traversal(root, L, R);
        return result;
    }
    
    private void traversal(TreeNode root, int L, int R) {
        if (root == null)  return;
        
        if (root.val >= L) traversal(root.left, L, R);
        if (root.val >= L && root.val <= R) result += root.val;
        if (root.val <= R) traversal(root.right, L, R);
    }
}