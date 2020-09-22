// Leetcode 1592: Rearrange Spaces Between Words
import java.util.*;

public class Solution1592 {
    public String reorderSpaces(String text) {
        // TC:O(N), SC:(N)
        int space_count = 0;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                space_count++;
            }
        }
        String[] word = text.trim().split("[ ]+");
        int word_count = word.length;
        if (word_count == 1) {
            StringBuilder ret = new StringBuilder();
            ret.append(word[0]);
            for (int i = 0; i < space_count; i++) {
                ret.append(" ");
            }
            return ret.toString();
        }
        int right_space = space_count / (word_count-1);
        int left_space = space_count%(word_count-1);
        
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < word_count; i++) {
            ret.append(word[i]);
            if (i != word_count - 1) {
                for (int j = 0; j < right_space; j++) {
                    ret.append(" ");
                }
            } else {
                for (int j = 0; j < left_space; j++) {
                    ret.append(" ");
                }
            }
        }
        return ret.toString();
    }
}
