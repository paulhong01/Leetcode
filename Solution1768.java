// Leetcode 1728: Merge Strings Alternately
import java.util.*;

class Solution1768 {
    public String mergeAlternately(String word1, String word2) {
        // TC:O(N1 + N2), SC:(1), where N1 = word1.length and N2 = word2.length
        StringBuilder ret = new StringBuilder();
        int idx1 = 0, idx2 = 0;
        while (idx1 < word1.length() || idx2 < word2.length()) {
            if (idx1 < word1.length()) {
                ret.append(word1.charAt(idx1));
                ++idx1;
            }
            if (idx2 < word2.length()) {
                ret.append(word2.charAt(idx2));
                ++idx2;
            }
        }
        return ret.toString();
    }
}
