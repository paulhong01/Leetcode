// Leetcode 5: Longest Palindromic Substring
import java.util.*;

public class Solution5 {
    public static void main(String[] args) {
        // String s = "babad";
        // String s = "cbbd";
        String s = "bb";

        Solution5 sol = new Solution5();
        String res = sol.longestPalindrome(s);
        System.out.println(res);
    }

    public String longestPalindrome(String s) {
        // TC:O(n^2), SC:O(1)
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            String tempres = check(s, i, i);
            result = (tempres.length() > result.length())?tempres:result;
            tempres = check(s, i, i + 1);
            result = (tempres.length() > result.length())?tempres:result;
        }

        return result;
    }

    private String check(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }
}