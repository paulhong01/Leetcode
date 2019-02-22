// Leetcode 993: Cousins in Binary Tree
import java.util.*;

class Solution993 {
    public boolean isCousins(TreeNode root, int x, int y) {
        // BFS: TC:O(n), SC:O(n)
        Map<Integer, List> map = new HashMap();
        Queue<TreeNode> queue = new LinkedList();
        if (root != null) {
            queue.add(root);
            map.put(root.val, new ArrayList());
        }
        
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    map.put(cur.left.val, new ArrayList());
                    map.get(cur.left.val).add(cur.val);
                    map.get(cur.left.val).add(level+1);
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    map.put(cur.right.val, new ArrayList());
                    map.get(cur.right.val).add(cur.val);
                    map.get(cur.right.val).add(level+1);
                    queue.add(cur.right);
                }
            }
            level++;
        }
        
        List xlist = map.get(x);
        List ylist = map.get(y);
        if (xlist.size() == 0 || ylist.size() == 0) return false;
        if (xlist.get(1) == ylist.get(1) && xlist.get(0) != ylist.get(0))   return true;
        else return false;
    }
}