// Leetcode 1021: Remove Outermost Parentheses
import java.util.*;

class Solution1021 {
    public String removeOuterParentheses(String S) {
        if (S.length() == 0)    return "";
        String result = "";
        String cur = "";
        int count = 0;
        for (char c: S.toCharArray()) {
            cur += c;
            if (c == '(') {
                count++;
            } else {
                count--;
                if (count == 0) {
                    result += cur.substring(1, cur.length()-1);
                    cur = "";
                }
            }
        }
        return result;
        
    }
}