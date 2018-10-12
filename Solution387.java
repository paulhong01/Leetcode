// Leetcode 387: First Unique Character in a String
import java.util.*;

public class Solution387 {
    public static void main(String[] args) {
        String s = "leetcode";

        Solution387 sol = new Solution387();
        int result = sol.firstUniqChar(s);
        System.out.println(result);
    }

    public int firstUniqChar(String s) {
        // TC:O(n), SC:O(1)
        int[] check = new int[26];
        for (char c: s.toCharArray()) {
            check[c-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (check[s.charAt(i) - 'a'] == 1)   return i;
        }
        return -1;
    }
}