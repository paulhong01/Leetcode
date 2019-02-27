class Solution998 {
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
        // Recursive, TC:O(N), SC:O(N)
        // if (root != null && root.val > val) {
        //     root.right = insertIntoMaxTree(root.right, val);
        //     return root;
        // } 
        // TreeNode node = new TreeNode(val);
        // node.left = root;
        // return node;
        
        // Iterative: TC:O(N), SC:O(1)
        TreeNode node = new TreeNode(val), cur = root;
        if (root.val < val) {
            node.left = root;
            return node;
        }
        while (cur.right != null && cur.right.val > val) {
            cur = cur.right;
        }
        node.left = cur.right;
        cur.right = node;
        return root;
    }
}