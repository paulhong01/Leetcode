// Leetcode 536: Construct Binary Tree from String
import java.util.*;

class Solution536 {
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack();
        int idx = 0;
        while (idx < s.length()) {
            char c = s.charAt(idx);
            if (c == ')') {
                stack.pop();
                idx++;
            } else if ((c >= '0' && c <= '9') || c == '-') {
                int idx2 = idx+1;
                while (idx2<s.length() && s.charAt(idx2)>='0' && s.charAt(idx2) <= '9') idx2++;
                TreeNode cur = new TreeNode(Integer.valueOf(s.substring(idx, idx2)));
                if (!stack.isEmpty()) {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) {
                        parent.left = cur;
                    } else {
                        parent.right = cur;
                    }
                }
                stack.push(cur);
                idx = idx2;
            } else {
                idx++;
            }
        }
        return stack.isEmpty()?null:stack.peek();
    }
}