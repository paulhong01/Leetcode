// Leetcode 437: Path Sum III
import java.util.*;

public class Solution437 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        root.right.right = new TreeNode(11);
        int sum = 8;

        Solution437 sol = new Solution437();
        int res = sol.pathSum(root, sum);
        System.out.println(res);
    }

    public int pathSum(TreeNode root, int sum) {
        // Method 1: DFS, TC:O(n^2), SC:O(n)
        // if (root == null) {
        //     return 0;
        // }
        // int result = 0;
        // result += find(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        // return result;

        // Method 2: Using HashMap
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    private int helper(TreeNode root, int cursum, int target, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        
        cursum += root.val;
        int res = map.getOrDefault(cursum - target, 0);
        map.put(cursum, map.getOrDefault(cursum, 0) + 1);

        res += helper(root.left, cursum, target, map) + helper(root.right, cursum, target, map);
        map.put(cursum, map.getOrDefault(cursum, 0) - 1);

        return res;

    }

    private int find(TreeNode src, int target) {
        int count = 0;
        if (src == null) {
            return 0;
        } else if (src.val == target) {
            count++;
        }
        count += find(src.left, target - src.val) + find(src.right, target - src.val);
        return count;
    }
}