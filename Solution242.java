// Leetcode 242: Valid Anagram
import java.util.*;

public class Solution242 {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";

        Solution242 sol = new Solution242();
        boolean res = sol.isAnagram(s, t);
        if (res) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())   return false;
        int[] col = new int[26];
        for (char c: s.toCharArray()) {
            col[c - 'a']++;
        }

        for (char c: t.toCharArray()) {
            col[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (col[i] != 0)    return false;
        }
        return true;
    }
}