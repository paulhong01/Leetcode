// Leetcode 655: Print Binary Tree
import java.util.*;

public class Solution655 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(3);

        Solution655 sol = new Solution655();
        List<List<String>> res = sol.printTree(root);
        System.out.println(res);
    }

    public List<List<String>> printTree(TreeNode root) {
        // TC:O(h*2^h), SC:O(h*2^h)
        int height = getheight(root);
        String[][] tempresult = new String[height][(1<<height)-1];
        for(String[] temp: tempresult) {
            Arrays.fill(temp,"");
        }
        fill(root, tempresult, 0, 0, tempresult[0].length);

        List<List<String>> result = new ArrayList<List<String>>();
        for (String[] temp: tempresult) {
            result.add(Arrays.asList(temp));
        }
        return result;
    }

    private void fill(TreeNode cur, String[][] tempresult, int row, int l, int r) {
        if (cur == null) {
            return;
        }

        int mid = (l + r)/2;
        tempresult[row][mid] = Integer.toString(cur.val);
        fill(cur.left, tempresult, row+1, l, mid);
        fill(cur.right, tempresult, row+1, mid+1, r);
    }

    private int getheight(TreeNode cur) {
        if (cur == null) {
            return 0;
        }

        return 1 + Math.max(getheight(cur.left), getheight(cur.right));
    }
}