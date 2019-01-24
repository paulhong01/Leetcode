// Leetcode 47: Permutations II
import java.util.*;

class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> set = new HashSet();
        List<Integer> cur = new ArrayList();
        Set<Integer> visited = new HashSet();
        traversal(nums, set, cur, visited);
        
        return new ArrayList(set);
    }
    
    private void traversal(int[] nums, Set<List<Integer>> set, List<Integer> cur, Set<Integer> visited) {
        if (cur.size() == nums.length) {
            set.add(new ArrayList(cur));
            return;
        }
        
        
        for(int i = 0; i < nums.length; i++) {
            if (!visited.contains(i)) {
                visited.add(i);
                cur.add(nums[i]);
                traversal(nums, set, cur, visited);
                visited.remove(i);
                cur.remove(cur.size() - 1);
            }
        }
    }
}