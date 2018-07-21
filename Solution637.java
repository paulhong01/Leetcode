//Leetcode 637 : Average of Levels in Binary Tree
import java.util.*;

public class Solution637 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution637 sol = new Solution637();
        List<Double> res = sol.averageOfLevels(root);
        System.out.println(res);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        // TC:O(n), SC:O(m), where n = number of elements in the tree, m = maximum number of nodes at any level
        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        List<Double> result = new ArrayList();
        while (!q.isEmpty()) {
            int size = q.size();
            long count = 0;
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                count += (cur.val);
                if (cur.left != null)   q.add(cur.left);
                if (cur.right != null)  q.add(cur.right);
            }
            result.add(count/(double)size);
        }
        return result;
       
    }
}