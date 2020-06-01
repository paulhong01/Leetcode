// Leetcode 1457: Pseudo-Palindromic Paths in a Binary Tree
import java.util.*;

class Solution1457 {
    int ret = 0, length = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] count = new int[10];
        traversal(root, count);
        return ret;
    }
    
    public void traversal(TreeNode cur, int[] count) {
        if (cur == null) {
            return;
        } else if (cur.left == null && cur.right == null) {
            count[cur.val]++;
            length++;
            if (check(count)) {
                ret++;
            }
            length--;
            count[cur.val]--;
            return;
        }
        
        count[cur.val]++;
        length++;
        traversal(cur.left, count);
        traversal(cur.right, count);
        length--;
        count[cur.val]--;
    }
    
    public boolean check(int[] count) {
        if (length % 2 == 0) {
            for (int i = 1; i <= 9; i++) {
                if (count[i] != 0 && count[i] % 2 ==1) {
                    return false;
                }
            }
        } else {
            boolean has_odd = false;
            for (int i = 1; i <= 9; i++) {
                if (count[i] != 0 && count[i] % 2 == 1) {
                    if (!has_odd) {
                        has_odd = true;
                    } else {
                        return false;
                    }
                }
            }
        }
        
        return true;
    }
}