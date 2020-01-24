// Leetcode 1324: Print Words Vertically
import java.util.*;


class Solution1324 {
    public List<String> printVertically(String s) {
        // TC: TC:O(N), SC:O(N), where N = s.length()
        String[] word = s.split(" ");
        int max_length = 0;
        int[] bigger_after = new int[word.length];
        for (int i = word.length-1; i >=0 ; i--) {
            bigger_after[i] = max_length;
            if (word[i].length() >= max_length) {
                max_length = word[i].length();
            }             
        }
        
        
        List<String> ret = new ArrayList<>();
        for (int idx = 0; idx < max_length; idx++) {
            StringBuilder cur_str = new StringBuilder();
            for (int i = 0; i < word.length; i++) {
                if (idx < word[i].length()) {
                    cur_str.append(word[i].charAt(idx));
                } else if (idx < bigger_after[i]) {
                    cur_str.append(" ");
                }
            }
            ret.add(cur_str.toString());
        }
        return ret;
    }
}