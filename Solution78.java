// Leetcode 78: Subsets
import java.util.*;

public class Solution78{
    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        Solution78 sol = new Solution78();
        List<List<Integer>> result = sol.subsets(nums);
        System.out.println(result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        // Iteratively, it's really a nice thinking, reference by @sikp
        // TC:O(n*2^n), SC:O(2^n), where n = nums.length
        List<List<Integer>> result = new ArrayList<List<Integer>> ();
        result.add(new ArrayList<Integer>());

        for (int i = 0; i < nums.length; i++){
            int size = result.size();
            for (int j = 0; j < size; j++){
                List<Integer> subset = new ArrayList(result.get(j));
                subset.add(nums[i]);
                result.add(subset);
            }
        }
        
        return result;
    }
}