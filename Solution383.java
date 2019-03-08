// Leetcode 383: Ransom Note
import java.util.*;

class Solution383 {
    public static void main(String[] args) {
        String ransomNote = "a";
        String magazine = "b";
        Solution383 sol = new Solution383();
        if (sol.canConstruct(ransomNote, magazine)) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] check = new int[26];
        for (char c: magazine.toCharArray()) {
            check[c-'a']++;
        }
        
        for (char c: ransomNote.toCharArray()) {
            if (check[c-'a'] == 0)  return false;
            check[c-'a']--;
        }
        return true;
    }
}