//Leetcode 199: Binary Tree Right Side View
import java.util.*;

public class Solution199{
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);
        Solution199 s = new Solution199();
        List<Integer> result = s.rightSideView(root);
        for(int i: result)  System.out.printf("%d ", i);
        System.out.println("");
    }

    public List<Integer> rightSideView(TreeNode root) {
        // Method 1: BFS, TC:O(n), SC:O(n)
        /*
        List<Integer> result = new ArrayList();
        if (root == null)   return result;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if (i == 0){
                    result.add(cur.val);
                }
                if (cur.right != null)  q.add(cur.right);
                if (cur.left != null)   q.add(cur.left);
            }
        }
        return result;
        */
        // Method 2: DFS, TC:O(n), SC:O(n)
        List<Integer> result = new ArrayList();
        if (root == null)   return result;
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<Integer> result, int level){
        if (root == null)   return;
        if (result.size() == level){
            result.add(root.val);
        }

        helper(root.right, result, level+1);
        helper(root.left, result, level+1);
    }
}