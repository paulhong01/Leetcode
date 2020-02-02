// Leetcode 1332: Remove Palindromic Subsequences
import java.util.*;

class Solution1332 {
    public int removePalindromeSub(String s) {
        if (s.length() == 0) {
            return 0;
        } else if (isPalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }
    
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}