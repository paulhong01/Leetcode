// Leetcode 951: Flip Equivalent Binary Trees

class Solution951 {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // TC:O(n), SC:O(n)
        if (root1 == null && root2 == null) return true;
        else if (root1 == null || root2 == null)    return false;
        else {
            if (root1.val != root2.val) return false;
            else {
                return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right)) || (flipEquiv(root1.right, root2.left) && flipEquiv(root1.left, root2.right));
            }
        }
    }
}