class Solution {
    public int kthSmallest(TreeNode root, int k) {
        /* // Method 1: In order
        Stack<TreeNode> s = new Stack();
        TreeNode cur = root;
        int count = 1;
        while (cur != null || !s.isEmpty()){
            while (cur != null){
                s.push(cur);
                cur = cur.left;
            }
            
            cur = s.pop();
            if (count == k)
                return cur.val;
            else
                count++;
            
            cur = cur.right;
        }
        return -1;
        */
        // Method 2 : In order but travel left node one time only
        int count = countNode(root.left) + 1;
        if (count == k)
            return root.val;
        else if (k < count){
            int temp_result = kthSmallest(root.left, k);
            return temp_result;
        }else{
            int temp_result = kthSmallest(root.right, k - count);
            return temp_result;
        }
    }
    
    public int countNode(TreeNode cur){
        if (cur == null)
            return 0;
        return 1 + countNode(cur.left) + countNode(cur.right);
    }
}