// Leetcode 125: Valid Palindrome
import java.util.*;

class Solution125 {
    public boolean isPalindrome(String s) {
        // Two pointers, TC: O(N), SC:O(N)
        int l = 0, r = s.length()-1;
        while (l <= r) {
            while (l+1 <= r && (!Character.isLetter(s.charAt(l)) && !Character.isDigit(s.charAt(l)))) l++;
            while (l <= r-1 && (!Character.isLetter(s.charAt(r)) && !Character.isDigit(s.charAt(r)))) r--;
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r)))   return false;
            l++;
            r--;
        }
        return true;
    }
}