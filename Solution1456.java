// Leetcode 1456: Maximum Number of Vowels in a Substring of Given Length
import java.util.*;

class Solution1456 {
    public int maxVowels(String s, int k) {
        int ret = 0;
        for (int i = 0; i < k; i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                ret++;
            }
        }
        
        int temp = ret;
        for (int i = k; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                temp++;
            }
            if (s.charAt(i-k) == 'a' || s.charAt(i-k) == 'e' || s.charAt(i-k) == 'i' || s.charAt(i-k) == 'o' || s.charAt(i-k) == 'u') {
                temp--;
            }
            ret = Math.max(ret, temp);
        }
        return ret;
    }
}