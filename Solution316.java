// Leetcode 316: Remove Duplicate Letters
import java.util.*;

class Solution316 {
    public String removeDuplicateLetters(String s) {
        // Greedy + Stack: TC:O(N), SC:O(N)
        int[] count = new int[26];
        int len = s.length();
        for (int i = 0; i < len; i++) {
            count[s.charAt(i)-'a']++;
        }
        
        Stack<Character> stack = new Stack();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            count[c-'a']--;
            if (stack.contains(c))  continue;
            if (stack.isEmpty() || stack.peek() < c) {
                stack.push(c);
            } else {
                while (!stack.isEmpty() && stack.peek() > c && count[stack.peek()-'a']>=1) {
                    stack.pop();
                }
                stack.push(c);
            }
        }
        
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.insert(0, stack.pop());
        }
        return result.toString();
    }
}