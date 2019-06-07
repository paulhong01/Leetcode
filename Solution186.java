// Leetcode 186: Reverse Words in a String II
import java.util.*;

class Solution186 {
    public void reverseWords(char[] str) {
        // TC:O(N), SC:O(N)
        List<String> list = new ArrayList();
        String cur = "";
        for (char c : str) {
            if (c == ' ') {
                list.add(cur);
                cur = "";
            } else {
                cur += c;
            }
        }
        list.add(cur);
        int idx_str = 0;
        for (int i = list.size()-1; i >= 0; i--) {
            for (int idx = 0; idx < list.get(i).length(); idx++) {
                str[idx_str++] = list.get(i).charAt(idx);
            }
            if (idx_str < str.length)
                str[idx_str++] = ' ';
        }
        return;
    }
}