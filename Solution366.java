// Leetcode 366: Find Leaves of Binary Tree
import java.util.*;

class Solution366 {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> findLeaves(TreeNode root) {
        traversal(root);
        return result;
    }
    
    private int traversal(TreeNode cur) {
        if (cur == null)    return -1;
        
        int leftlayer = traversal(cur.left);
        int rightlayer = traversal(cur.right);
        int curlayer = Math.max(leftlayer, rightlayer)+1;
        
        if (result.size() < curlayer+1) {
            result.add(new ArrayList());
        }
        result.get(curlayer).add(cur.val);
        return curlayer;
    }
}