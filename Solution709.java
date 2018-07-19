//Leetcode 709: To Lower Case
import java.util.*;

public class Solution709 {
    public static void main(String[] args) {
        String str = "LOVELY";
        Solution709 sol = new Solution709();
        String res = sol.toLowerCase(str);
        System.out.println(res);
    }

    public String toLowerCase(String str) {
        // SC:O(N), TC:O(N), where N = str.length()
        int diff = 'A' - 'a';
        char[] ch = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] - 'A' >= 0 && ch[i] - 'Z' <= 0) {
                ch[i] = (char)(ch[i] - diff);
            }
        }
        return new String(ch);
    }
}