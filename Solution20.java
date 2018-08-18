// Leetcode 20: Valid Parentheses
import java.util.*;

public class Solution20 {
    public static void main(String[] args) {
        String s = "}";

        Solution20 sol = new Solution20();
        boolean res = sol.isValid(s);
        if (res) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }

    public boolean isValid(String s) {
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack();
        for (int i = 0; i < c.length; i++) {
            if (c[i] == '(') {
                stack.push(')');
            } else if (c[i] == '[') {
                stack.push(']');
            } else if (c[i] == '{') {
                stack.push('}');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char check = stack.pop();
                    if (check != c[i]) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty()?true:false;
    }
}