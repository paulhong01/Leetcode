// Leetcode 662: Maximum Width of Binary Tree
import java.util.*;

class Solution662 {
    public int widthOfBinaryTree(TreeNode root) {
        // TC:O(N), SC:O(N)
        int ret = 0;
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> queue_num = new LinkedList<>();
        if (root != null) {
            queue.add(root);
            queue_num.add(0);
        }
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            int cur_min = Integer.MAX_VALUE, cur_max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int cur_num = queue_num.poll();
                cur_min = Math.min(cur_min, cur_num);
                cur_max = Math.max(cur_max, cur_num);
                if (cur.left != null) {
                    queue.add(cur.left);
                    queue_num.add(cur_num*2);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                    queue_num.add(cur_num*2+1);
                }
            }
            ret = Math.max(ret, cur_max - cur_min);
        }
        return ret+1;
    }
}