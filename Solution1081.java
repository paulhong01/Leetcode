// Leetcode 1081: Smallest Subsequence of Distinct Characters
import java.util.*;

class Solution1081 {
    public String smallestSubsequence(String text) {
        // Greedy + Stack: TC:O(N), SC:O(N)
        int[] count = new int[26];
        for (char c : text.toCharArray()) {
            count[c-'a']++;
        }
        
        Stack<Character> stack = new Stack();
        for (char c : text.toCharArray()) {
            count[c-'a']--;
            if (stack.contains(c))  continue;
            if (stack.isEmpty() || stack.peek() < c) {
                stack.push(c);
            } else {
                 while (!stack.isEmpty() && count[stack.peek()-'a'] >= 1 && stack.peek() > c) {
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