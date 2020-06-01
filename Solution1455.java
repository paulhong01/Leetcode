// Leetcode 1455: Check If a Word Occurs As a Prefix of Any Word in a Sentence
import java.util.*;

class Solution1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] str_array = sentence.split(" ");
        for (int i = 0; i < str_array.length; i++) {
            if (str_array[i].startsWith(searchWord)) {
                return i+1;
            }
        }
        return -1;
    }
}