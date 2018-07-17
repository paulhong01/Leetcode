// Leetcode 508: Most Frequent Subtree Sum
import java.util.*;

public class Solution508{
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        
        Solution508 sol = new Solution508();
        int[] res = sol.findFrequentTreeSum(root);
        for(int r: res){
            System.out.printf("%d ", r);
        }
        System.out.println("");
    }
    private int maxcount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        // TC:O(n), SC:O(n), where n = number of elements in tree
        if (root == null)   return new int[0];
        Map<Integer, Integer> m = new HashMap();

        traversal(root, m);

        List<Integer> res_temp = new ArrayList();
        for (int key: m.keySet()){
            if (m.get(key) == maxcount){
                res_temp.add(key);
            }
        }

        int[] res = new int[res_temp.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = res_temp.get(i);
        }
        return res;
    }

    private int traversal(TreeNode cur, Map<Integer, Integer> m){
        int leftnum = (cur.left == null)?0:traversal(cur.left, m);
        int rightnum = (cur.right == null)?0:traversal(cur.right, m);
        int sum = leftnum + rightnum + cur.val;
        int count = m.getOrDefault(sum, 0) + 1;
        m.put(sum, count);
        maxcount = Math.max(maxcount, count);
        return sum;
    }
}