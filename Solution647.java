// Leetcode 647 : Palindromic Substrings
import java.util.*;

public class Solution647 {
    public static void main(String[] args) {
        String s = "aaa";

        Solution647 sol = new Solution647();
        int res = sol.countSubstrings(s);
        System.out.println(res);
    }

    private boolean checker(String temp, int l, int r) {
        while (l <= r) {
            if (temp.charAt(l) != temp.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        return true;
    }

    private int helper(String s, int l, int r) {
        int count = 0;
        while (l >=0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            count++;
            l--;
            r++;
        }
        return count;
    }

    public int countSubstrings(String s) {
        // Method 1: Brute Force, TC:O(n^3), SC:O(n)
        // int result = s.length();

        // for (int i = 0; i < s.length() - 1; i++) {
        //     for (int j = i + 1; j < s.length(); j++) {
        //         String temp = s.substring(i, j+1);
        //         if (checker(temp, 0, temp.length()-1)) {
        //             result++;
        //         }
        //     }
        // }

        // return result;

        // Method 2: TC:O(n^2), SC:O(1)
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            // Find all odd length palindrome with i as middle point.
            result += helper(s, i, i);
            // Find all even length parlindrome with i as middle point.
            result += helper(s, i, i+1);
        }
        return result;
    }
}