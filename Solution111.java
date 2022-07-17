// Leetcode 111: Minimum Depth of Binary Tree

class Solution {
    public int minDepth(TreeNode root) {
        // TC:O(N), SC:O(N)
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int depth = 0;
        if (root != null) {
            queue.add(root);
        }
        
        while (!queue.isEmpty()) {
            int cur_size = queue.size();
            ++depth;
            for (int i = 0; i < cur_size; ++i) {
                TreeNode cur = queue.poll();
                if (cur.left == null && cur.right == null) {
                    return depth;
                }
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return depth;
    }
}