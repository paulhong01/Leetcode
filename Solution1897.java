// Leetcode 1897: Redistribute Characters to Make All Strings Equal
import java.util.*;

class Solution1897 {
    public boolean makeEqual(String[] words) {
        // TC:O(N), SC:(1), N = words.length
        int[] word_count = new int[26];
        for (String word : words) {
            for (int i = 0; i < word.length(); ++i) {
                word_count[word.charAt(i)-'a']++;
            }
        }
        
        int N = words.length;
        for (int i = 0; i < 26; i++) {
            if (word_count[i] % N != 0) {
                return false;
            }
        }
        return true;
    }
}