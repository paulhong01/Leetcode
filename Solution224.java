// Leetcode 224: Basic Calculator
import java.util.*;

class Solution224 {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        int result = 0;
        int num = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                num = num*10 + (c-'0');
            } else if (c == '+') {
                result += sign*num;
                sign = 1;
                num = 0;
            } else if (c == '-') {
                result += sign*num;
                sign = -1;
                num = 0;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                sign = 1;
                result = 0;
                num = 0;
            } else if (c == ')') {
                result += sign*num;
                result *= stack.pop();
                result += stack.pop();
                num = 0;
            }
        }
        if (num != 0)   result += sign*num;
        return result;
    }
}