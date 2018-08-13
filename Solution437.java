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
        if (root == null) {
            return 0;
        }
        // System.out.println(root.val);
        int result = 0;
        // System.out.printf("root: %d, sum: %d\n", root.val, sum);
        result += find(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
        return result;
    }

    private int find(TreeNode src, int target) {
        int count = 0;
        if (src == null) {
            return 0;
        } else if (src.val == target) {
            count++;
        }
        // System.out.printf("Find : src: %d, target: %d\n", src.val, target);
        count += find(src.left, target - src.val) + find(src.right, target - src.val);
        return count;
    }
}