//Leetcode 107: Binary Tree Level Order Traversal II
import java.util.*;

public class Solution107{
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution107 s = new Solution107();
        List<List<Integer>> result = s.levelOrderBottom(root);
        for(List<Integer> r_i: result){
            for(int i: r_i){
                System.out.printf("%d ", i);
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // Method 1: BFS, TC:O(n), SC:O(n)
        /*
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if (root == null)   return result;

        Queue<TreeNode> q = new LinkedList();
        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            List<Integer> temp = new ArrayList();
            for (int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                temp.add(cur.val);
                if(cur.left != null)    q.add(cur.left);
                if (cur.right != null)  q.add(cur.right);
            }
            result.add(0, temp);
        }
        return result;
        */
        // Method 2: DFS, TC:O(n), SC:O(n)
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        helper(root, result, 0);
        return result;
    }

    private void helper(TreeNode root, List<List<Integer>> result, int level){
        if (root == null)   return;

        if (level >= result.size()){
            result.add(0, new ArrayList<Integer>());
        }
        result.get(result.size()-1-level).add(root.val);

        helper(root.left, result, level+1);
        helper(root.right, result, level+1);

    }
}