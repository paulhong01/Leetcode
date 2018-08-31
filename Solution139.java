// Leetcode 139: Word Break
import java.util.*;

public class Solution139 {
    public static void main(String[] args) {
        String s = "applepenapple";
        String[] temp = {"apple", "pen"};
        List<String> wordDict = Arrays.asList(temp);
        
        Solution139 sol = new Solution139();
        boolean res = sol.wordBreak(s, wordDict);
        if (res) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        // Method 1: Brute force with memorize, TC:O(n^2), SC:O(n)
        /* int[] check = new int[s.length()];
        Arrays.fill(check, 0);
        Set<String> wordSet = new HashSet(wordDict);
        return tracking(s, wordSet, check, 0); */

        // Method 2: Dynamic programming, TC:O(n^2), SC:O(n)
        boolean[] dp = new boolean[s.length() + 1];
        Set<String> wordSet = new HashSet(wordDict);
        dp[0] = true;
        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (dp[start] && wordSet.contains(s.substring(start, end))) {
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    private boolean tracking(String s, Set<String> wordSet, int[] check, int start) {
        if (start == s.length()) {
            return true;
        } 
        if (check[start] != 0) {
            return check[start] == 1?true:false;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            if (wordSet.contains(s.substring(start, end)) && tracking(s, wordSet, check, end)) {
                check[start] = 1;
                return true;
            } else {
                check[start] = 2;
            }
        }

        return false;
    }
}