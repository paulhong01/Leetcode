// Leetcode 102: Binary Tree Level Order Traversal
import java.util.*;

public class Solution102{
    public static void main(String[] args){
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution102 s = new Solution102();
        List<List<Integer>> result = s.levelOrder(root);
        for(List<Integer> i: result){
            for(int j: i){
                System.out.printf("%d ",j);
            }
            System.out.println("");
        }
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        // Method 1: DFS recursive, TC:O(n), SC:O(n)
        /*
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if (root == null)
            return result;
        helper(root, result, 0);
        return result;
        */
        // Method 2: Using queue, TC:O(n), SC:O(n)
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if (root == null)
            return result;

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
            result.add(temp);
        }
        return result;
        
    }

    private void helper(TreeNode root, List<List<Integer>> result, int level){
        if (root == null)   return;
        if(level+1 > result.size()){
            result.add(new ArrayList<Integer>());
        }
        result.get(level).add(root.val);
        helper(root.left, result, level+1);
        helper(root.right, result, level+1);
    }
}