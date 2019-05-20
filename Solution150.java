// Leetcode 150: Evaluate Reverse Polish Notation
import java.util.*;

class Solution150 {
    public int evalRPN(String[] tokens) {
        // TC:O(N), SC:O(N)
        Stack<Integer> stack = new Stack();
        for (String t: tokens) {
            if (t.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a+b);
            } else if (t.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            } else if (t.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a*b);
            } else if (t.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            } else {
                stack.push(Integer.valueOf(t));
            }
        }
        return stack.pop();
    }
}