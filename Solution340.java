// Leetcode 340: Longest Substring with At Most K Distinct Characters
import java.util.*;

class Solution340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // TC:O(N), SC:O(N)
        int S = s.length();
        if (S*k == 0)   return 0;
        
        int l = 0, r = 0;
        Map<Character, Integer> map = new HashMap();
        
        int result = 0;
        while (r < S) {
            map.put(s.charAt(r), r++);
            if (map.size() == k+1) {
                int del_idx = Collections.min(map.values());
                map.remove(s.charAt(del_idx));
                l = del_idx+1;
            }
            result = Math.max(result, r-l);
        }
        return result;
    }
}