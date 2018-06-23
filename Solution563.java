import java.util.*;

class Solution563{
    private int result = 0;
    public static void main(String args[]){
        TreeNode root = new TreeNode(1);
        TreeNode leftnode = new TreeNode(2);
        TreeNode rightnode = new TreeNode(3);
        root.left = leftnode;
        root.right = rightnode;
        Solution563 s = new Solution563();
        int totalresult = s.findTilt(root);
        System.out.printf("%d \n", totalresult);
    }

    public int findTilt(TreeNode root){
        traversal(root);
        return result;
    }

    public int traversal(TreeNode cur){
        if (cur == null)
            return 0;
        int left = traversal(cur.left);
        int right = traversal(cur.right);
        result += Math.abs(left - right);
        return (left+right+cur.val);
    }
}