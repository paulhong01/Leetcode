// Leetcode 131: Palindrome Partitioning
import java.util.*;

class Solution131 {
    public List<List<String>> partition(String s) {
        // TC:O(2^n-n-2), SC:O(N)
        List<List<String>> result = new ArrayList();
        List<String> cur = new ArrayList();
        traversal(result, cur, 0, s);
        return result;
    }
    
    private void traversal(List<List<String>> result, List<String> cur, int pos, String s) {
        if (pos >= s.length()) {
            result.add(new ArrayList(cur));
            return;
        }
        
        for (int i = pos; i < s.length(); i++) {
            if (check(s.substring(pos, i+1))) {
                cur.add(s.substring(pos, i+1));
                traversal(result, cur, i+1, s);
                cur.remove(cur.size()-1);
            }
        }
    }
    
    private boolean check(String s) {
        int l = 0, r = s.length()-1;
        if (l == r) return true;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}