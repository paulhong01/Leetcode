// Leetcode 151: Reverse Words in a String
import java.util.*;

public class Solution151 {
    public static void main(String[] args) {
        String s = "   a   b ";

        Solution151 sol = new Solution151();
        String res = sol.reverseWords(s);
        System.out.println(res);
    }

    public String reverseWords(String s) {
        // TC:O(n), SC:O(n)
        s = s.trim();
        String[] s_arr = s.split("[ ]+");
        int l = 0, r = s_arr.length - 1;
        while (l < r) {
            String temp = s_arr[l].trim();
            s_arr[l++] = s_arr[r].trim();
            s_arr[r--] = temp;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s_arr.length; i++) {
            result.append(s_arr[i] + " ");
        }
        return result.toString().trim();
    }
}