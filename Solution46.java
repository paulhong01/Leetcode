//Leetcode 46: Permutations
import java.util.*;

public class Solution46{
    public static void main(String[] args){
        int[] nums = {1, 2, 3};
        Solution46 sol = new Solution46();
        List<List<Integer>> result = sol.permute(nums);
        for(List<Integer> l: result){
            for(int r: l){
                System.out.printf("%d ", r);
            }
            System.out.println("");
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        // TC:O(n!), SC:O(n), where n = nums.length
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), 0, nums, visited);
        return result;
    }

    private void helper(List<List<Integer>> result, List<Integer> cur, int pos, int[] nums, boolean[] visited){
        if (cur.size() == visited.length){
            result.add(new ArrayList(cur));
            return;
        }

        for (int i = 0; i < nums.length; i++){
            if(!visited[i]){
                visited[i] = true;
                cur.add(nums[i]);
                helper(result, cur, pos+1, nums, visited);
                visited[i] = false;
                cur.remove(pos);
            }
        }
    }
}