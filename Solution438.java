// Leetcode 438: Find All Anagrams in a String
import java.util.*;

class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        // Sliding windows: TC:O(N), SC:O(N)
        List<Integer> result = new ArrayList();
        Map<Character, Integer> map = new HashMap();
        for (char c : p.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        
        Set<Integer> deleted = new HashSet();
        int count = map.size();
        for (int i = s.length()-1; i >= 0; i--) {
            if (map.containsKey(s.charAt(i))) {
                int update = map.get(s.charAt(i))-1;
                if (update == 0)    count--;
                if (count == 0 && update == 0)    result.add(i);
                map.put(s.charAt(i), update);
                deleted.add(i);
            }
            if (s.length() - i >= p.length()) {
                int delete_idx = i + p.length()-1;
                char update = s.charAt(delete_idx);
                if (map.containsKey(update)) {
                    map.put(update, map.get(update)+1);
                    if (map.get(update) == 1)   count++;
                }
            }
        }
        return result;
    }
}