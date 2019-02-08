// Leetcode 988: Smallest String Starting From Leaf
import java.util.*;

class Solution988 {
    
    String result = "~";
    
    public String smallestFromLeaf(TreeNode root) {
        traversal(root, new StringBuilder());
        return result;
    }
    
    private void traversal(TreeNode cur, StringBuilder curstr) {
        if (cur == null)     return;
        curstr.append((char)(cur.val + 'a'));
        if (cur.left == null && cur.right == null) {
            curstr.reverse();
            String temp = curstr.toString();
            curstr.reverse();
            if (temp.compareTo(result) < 0) {
                result = temp;
            }
        }
        
        traversal(cur.left, curstr);
        traversal(cur.right, curstr);
        curstr.deleteCharAt(curstr.length() - 1);
    }
   
}