// Leetcode 205: Isomorphic Strings
import java.util.*;

class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        // TC:O(N), SC:O(N)
        Map<Character, Integer> map1 = new HashMap();
        Map<Character, Integer> map2 = new HashMap();
        for (int i = 0; i < s.length(); i++) {
            int value1 = map1.getOrDefault(s.charAt(i), -1);
            map1.put(s.charAt(i), i);
        
            int value2 = map2.getOrDefault(t.charAt(i), -1);
            map2.put(t.charAt(i), i);
            if (value1 != value2) return false;
        }
        return true;
    }
}