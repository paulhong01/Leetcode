//Leetcode 515: Find Largest Value in Each Tree Row
import java.util.*;

public class Solution515 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(9);

        Solution515 sol = new Solution515();
        List<Integer> result = sol.largestValues(root);
        System.out.println(result);
    }

    public List<Integer> largestValues(TreeNode root) {
        // BFS, TC:O(n), SC:O(m), where m = maximum number of nodes in the layer
        Queue<TreeNode> q = new LinkedList();
        List<Integer> res = new ArrayList();
        if (root != null)
            q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            int tempmax = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                tempmax = cur.val > tempmax?cur.val:tempmax;
                if (cur.left != null)   q.add(cur.left);
                if (cur.right != null)  q.add(cur.right);
            }
            res.add(tempmax);
        }
        return res;
    }
}