// Leetcode 680: Valid Palindrome II
import java.util.*;

class Solution680 {
    public boolean validPalindrome(String s) {
        // TC:O(N), SC:O(N)
        return helper(s, 0, s.length()-1, false);
    }
    
    private boolean helper(String s, int l, int r, boolean chance) {
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                if (!chance) {
                    return helper(s, l+1, r, true)||helper(s, l, r-1, true);
                } else {
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }
}