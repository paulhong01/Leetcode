//Leetcode 216: Combination Sum III
import java.util.*;

public class Solution216{
    public static void main(String[] args){
        int k = 3, n = 9;
        Solution216 sol = new Solution216();
        List<List<Integer>> result = sol.combinationSum3(k, n);
        System.out.println(result);
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        // Backtracking, TC:O(9!), SC:O(9)
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), 0, 0, k, n);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> cur, int sum, int pos, int length, int target){
        // Stop condiction: the length of cur equals the required length
        if (cur.size() == length){
            if (sum == target){ // Accepted set
                result.add(new ArrayList<Integer>(cur));
            }
            return;
        }
        
        for (int i = (pos==0)?1:cur.get(pos-1)+1; i <= 9; i++){ // Prevent duplicate combinations
            if (sum + i > target)
                break;
            
            cur.add(i);
            sum += i;
            helper(result, cur, sum, pos+1, length, target);
            // Reset this value
            sum -= i;
            cur.remove(pos);
            
        }
    }
}