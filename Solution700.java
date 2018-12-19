// Leetcode 700: Search in a Binary Search Tree

class Solution700 {
    public TreeNode searchBST(TreeNode root, int val) {
        // TC:O(log(n)), SC:O(log(n))
        if (root == null)   return null;
        else if (root.val == val)   return root;
        else if (root.val > val)    return searchBST(root.left, val);
        else    return searchBST(root.right, val);
    }
}