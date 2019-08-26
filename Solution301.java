// Leetcode 301: Remove Invalid Parentheses
import java.util.*;


class Solution {
    int min_modify;
    Map<Integer, Set<String>> map;
    public List<String> removeInvalidParentheses(String s) {
        // TC:O(2^N), SC:O(2^N)
        min_modify = s.length();
        map = new HashMap();
        helper(s, 0, s.length());
        return new ArrayList(map.getOrDefault(min_modify, new HashSet()));
    }
    
    private boolean checker(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
                if (count < 0)  return false;
            }
        }
        return count == 0;
    }
    
    private void helper(String s, int idx, int original_length) {
        if (idx >= s.length() && checker(s)) {
            int num_remove = original_length - s.length();
            min_modify = Math.min(min_modify, num_remove);
            if (!map.containsKey(num_remove)) {
                map.put(num_remove, new HashSet());
            }
            
            map.get(num_remove).add(s);
            return;
        } else if (idx >= s.length()) {
            return;
        }
        helper(s, idx+1, original_length);
        helper(s.substring(0, idx)+s.substring(idx+1), idx, original_length);
    }
}