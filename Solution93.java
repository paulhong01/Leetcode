// Leetcode 93: Restore IP Addresses
import java.util.*;

class Solution93 {
    int n;
    String s;
    List<String> result = new ArrayList();
    LinkedList<String> segments = new LinkedList<>();
    
    private boolean valid(String segment) {
        int m = segment.length();
        if (m > 3 || m <= 0)  return false;
        return (segment.charAt(0) != '0')?(Integer.valueOf(segment) <= 255):(m==1);
    }
    
    private void update_output(int curpos) {
        String segment = s.substring(curpos, n);
        if (valid(segment)) {
            segments.add(segment);
            result.add(String.join(".", segments));
            segments.removeLast();
        }
    }
    
    private void backtracking(int prevpos, int dotnum) {
        int maxpos = Math.min(n, prevpos+4);
        for (int curpos = prevpos; curpos < maxpos; curpos++) {
            String segment = s.substring(prevpos, curpos+1);
            if (valid(segment)) {
                segments.add(segment);
                if (dotnum+1 == 4) {
                    update_output(curpos+1);
                } else {
                    backtracking(curpos+1, dotnum+1);
                }
                segments.removeLast();
            }
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        // TC:O(1), SC:O(1)
        n = s.length();
        this.s = s;
        backtracking(0, 1);
        return result;
    }
}