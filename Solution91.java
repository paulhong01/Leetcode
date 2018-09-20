// Leetcode 91: Decode Ways
import java.util.*;

public class Solution91 {
    public static void main(String[] args) {
        String s = "226";

        Solution91 sol = new Solution91();
        int res = sol.numDecodings(s);
        System.out.println(res);
    }

    public int numDecodings(String s) {
        // Method 1: Recursively, TC:O(2^n), SC:O(1)
        // return s.length() == 0?0:helper(0, s);

        // Method 2: Dynamic programming
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;
        for (int i  = s.length()-1; i >= 0; i--) {
            if (s.charAt(i) == '0') dp[i] = 0;
            else {
                dp[i] = dp[i + 1];
                if (i < s.length() - 1 && (s.charAt(i) == '1'|| (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) dp[i] += dp[i + 2];
            }
        }
        return s.length()==0?0:dp[0];
    }

    private int helper(int idx, String s) {
        if (idx == s.length())  return 1;
        if (s.charAt(idx) == '0')   return 0;
        int res = helper(idx + 1, s);
        if (idx < s.length() -1 && (s.charAt(idx) == '1'|| (s.charAt(idx) == '2' && s.charAt(idx + 1) < '7'))) res += helper(idx + 2, s);
        return res;
    }
}