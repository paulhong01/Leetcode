// Leetcode 1816: Truncate Sentence
import java.util.*;

class Solution1816 {
    public String truncateSentence(String s, int k) {
        // TC:O(N), SC:O(N)
        String[] words = s.split("[ ]+");
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < k; i++) {
            if (i == 0) {
                ret.append(words[i]);
            } else {
                ret.append(" "+words[i]);
            }
        }
        return ret.toString();
    }
}