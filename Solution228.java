// Leetcode 228: Summary Ranges
import java.util.*;

class Solution228 {
    public List<String> summaryRanges(int[] nums) {
        // Linear: TC:O(N), SC:O(1)
        if (nums.length == 0)   return new ArrayList();
        List<String> result = new ArrayList();
        int l = nums[0], r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i-1]+1) {
                r = nums[i];
                continue;
            } else {
                if (r == l) {
                    result.add(String.valueOf(l));
                } else {
                    result.add(String.valueOf(l)+"->"+String.valueOf(r));
                }
                l = nums[i];
                r = l;
            }
        }
        if (r == l) {
            result.add(String.valueOf(l));
        } else {
            result.add(String.valueOf(l)+"->"+String.valueOf(r));
        }
        return result;
    }
}