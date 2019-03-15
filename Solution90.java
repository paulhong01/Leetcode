// Leetcode 90: Subsets II
import java.util.*;

class Solution90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        result.add(new ArrayList());
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet();
        
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> newlist = new ArrayList(result.get(j));
                newlist.add(nums[i]);
                if (!set.contains(newlist)) {
                    result.add(newlist);
                    set.add(newlist);
                } 
            }
        }
        return result;
        
    }
}