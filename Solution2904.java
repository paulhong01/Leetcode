// Leetcode 2904: Shortest and Lexicographically Smallest Beautiful String

public class Solution2904 {
    public String shortestBeautifulSubstring(String s, int k) {
        // TC:O(N^2), SC:O(1)
        int n = s.length();
        String ans = "";
        int i = 0, j = 0;
        int c = 0;
        
        while (j < n) {
            if (s.charAt(j) == '1') {
                c++;
            }
            if (c == k) {
                while (i < n && c == k) {
                    String s1 = s.substring(i, j + 1);
                    if (ans.isEmpty() || s1.length() < ans.length()) {
                        ans = s1;
                    } else if (s1.length() == ans.length()) {
                        ans = (ans.compareTo(s1) < 0) ? ans : s1;
                    }
                    if (s.charAt(i) == '1') {
                        c--;
                    }
                    i++;
                }
            }
            j++;
        }
        return ans;
    }
}
