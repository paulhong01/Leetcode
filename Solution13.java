// Leetcode 13: Roman to Integer
import java.util.*;

public class Solution13 {
    public static void main(String[] args) {
        String s = "MCMXCIV";

        Solution13 sol = new Solution13();
        int res = sol.romanToInt(s);
        System.out.println(res);
    }

    public int romanToInt(String s) {
        // TC:O(n), SC:O(1)
        Map<Character, Integer> notation = new HashMap();
        notation.put('I', 1);
        notation.put('V', 5);
        notation.put('X', 10);
        notation.put('L', 50);
        notation.put('C', 100);
        notation.put('D', 500);
        notation.put('M', 1000);
        char[] c = s.toCharArray();

        int prev = 0;
        int result = 0;
        for (int i = c.length - 1; i >= 0; i--) {
            int cur = notation.getOrDefault(c[i], 0);
            result += (cur >= prev)?cur:cur*(-1);
            prev = cur;
        }
        return result;
    }
}