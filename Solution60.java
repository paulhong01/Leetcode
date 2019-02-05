// Leetcode 60: Permutation Sequence
import java.util.*;

class Solution60 {
    int count = 1;
    String result = "";
    public String getPermutation(int n, int k) {
        Set<Integer> set = new HashSet();
        StringBuilder cur = new StringBuilder();
        traversal(n, k, set, cur);
        return result;
    }
    
    private void traversal(int n, int k, Set<Integer> set, StringBuilder cur) {
        if (cur.length() == n && count == k) {
            result = cur.toString();
            count++;
            return;
        } else if (cur.length() == n) {
            count++;
            return;
        }
        
        for (int i = 1; i <= n; i++) {
            if (!set.contains(i)) {
                set.add(i);
                cur.append(i);
                traversal(n, k, set, cur);
                cur.deleteCharAt(cur.length()-1);
                set.remove(i);
            }
        }
    }
}