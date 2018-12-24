// Leetcode 872: Leaf-Similar Trees
import java.util.*;

class Solution872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList();
        List<Integer> leaf2 = new ArrayList();
        traversal(leaf1, root1);
        traversal(leaf2, root2);
        return leaf1.equals(leaf2);
    }
    
    private void traversal(List<Integer> leaf, TreeNode cur) {
        if (cur == null)    return;
        else if (cur.left == null && cur.right == null) {
            leaf.add(cur.val);
            return;
        }
        
        traversal(leaf, cur.left);
        traversal(leaf, cur.right);
    }
    
}