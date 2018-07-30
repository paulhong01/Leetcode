// Leetcode 337 : House Robber III
import java.util.*;

public class Solution337 {
    public static void main(String[] args) {
        // TreeNode root = new TreeNode(3);
        // root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        // root.left.right = new TreeNode(3);
        // root.right.right = new TreeNode(1);
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(3);

        Solution337 sol = new Solution337();
        int res = sol.rob(root);
        System.out.println(res);
    }

    public int rob(TreeNode root) {
        // Method 1 : TC:O(n), SC:O(n)
        // Map<TreeNode, Integer> map = new HashMap();
        // int result = helper(root, map);
        // return result;

        // Method 2 : TC:O(n), SC:O(1)
        int[] res = helper2(root);
        return Math.max(res[0], res[1]);
    }

    private int[] helper2(TreeNode cur) {
        if (cur == null) {
            return new int[2];
        }

        int[] left = helper2(cur.left);
        int[] right = helper2(cur.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = cur.val + left[0] + right[0];

        return res;
    }

    private int helper(TreeNode cur, Map<TreeNode, Integer> map) {
        if (map.containsKey(cur)) {
            return map.get(cur);
        } else if (cur == null) {
            map.put(cur, 0);
            return 0;
        } else if (cur.left == null && cur.right == null) {
            map.put(cur, cur.val);
            return cur.val;
        }

        int templeft = 0, tempright = 0;
        if (cur.left != null) {
            templeft = helper(cur.left.left, map) + helper(cur.left.right, map);
        }
        if (cur.right != null) {
            tempright = helper(cur.right.left, map) + helper(cur.right.right, map);
        }
        int choiceone = cur.val + templeft + tempright;
        int choicetwo = helper(cur.left, map) + helper(cur.right, map);
        int tempans = Math.max(choiceone, choicetwo);
        map.put(cur, tempans);
        return tempans;
    }
}