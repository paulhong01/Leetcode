// Leetcode 103: Binary Tree Zigzag Level Order Traversal
import java.util.*;

public class Solution103 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution103 sol = new Solution103();
        List<List<Integer>> result = sol.zigzagLevelOrder(root);
        System.out.println(result);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList();
        List<List<Integer>> result = new ArrayList();
        boolean lefttoright = true;
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                temp.add(cur.val);
                if (cur.left != null)   queue.add(cur.left);
                if (cur.right != null)  queue.add(cur.right);
            }
            if (!lefttoright)   Collections.reverse(temp);
            result.add(temp);
            lefttoright = !lefttoright;
        }
        return result;
    }
}