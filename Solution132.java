// Leetcode 132: Palindrome Partitioning II
import java.util.*;

class Solution {
    public int minCut(String s) {
        // Method 1 : Backtracking, Time exceeded limited
        // List<Integer> result = new ArrayList();
        // List<String> cur = new ArrayList();
        // helper(s, 0, cur, result);
        // int ret = s.length()-1;
        // for (int res : result) {
        //     ret = Math.min(ret, res);
        // }
        // return ret;
        
        // Method 2: DP, TC:O(N^2), SC:O(N)
        int N = s.length();
        int[] dp = new int[N];
        boolean[][] isPali = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            dp[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j <= 1 || isPali[j+1][i-1] == true)) {
                    isPali[j][i] = true;
                    if (j == 0) {
                        dp[i] = 0;
                    } else {
                        dp[i] = Math.min(dp[i], dp[j-1]+1);
                    }
                }
            }
        }
        return dp[N-1];
    }
    
    private void helper(String s, int start, List<String> cur, List<Integer> result) {
        if (start == s.length()) {
            result.add(cur.size()-1);
            return;
        }
        
        for (int end = s.length(); end >= start+1; end--) {
            String cur_string = s.substring(start, end);
            if (check(cur_string)) {
                cur.add(cur_string);
                helper(s, end, cur, result);
                cur.remove(cur.size()-1);
                return;
            }
        }
    }
    
    private boolean check(String s) {
        int l = 0, r = s.length()-1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}