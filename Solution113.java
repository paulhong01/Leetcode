// Leetcode 113: Path Sum II
import java.util.*;

class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList();
        List<Integer> cur = new ArrayList();
        traversal(root, sum, cur, result);
        return result;
    }
    
    private void traversal(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> result) {
        if (root == null)   return;
        
        cur.add(root.val);
        if (root.left == null & root.right == null && sum == root.val) {
            result.add(new ArrayList(cur));
        } else {
            traversal(root.left, sum-root.val, cur, result);
            traversal(root.right, sum-root.val, cur, result);
        }
        cur.remove(cur.size()-1);
        return;
    }
}