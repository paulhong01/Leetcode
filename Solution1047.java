// Leetcode 1047: Remove All Adjacent Duplicates In String
import java.util.*;

class Solution1047 {
    public String removeDuplicates(String S) {
        // Stack, TC:O(N), SC:O(N)
        StringBuilder sb = new StringBuilder(S);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i-1) != sb.charAt(i)) {
                stack.push(1);
            } else {
                int update = stack.pop()+1;
                if (update == 2) {
                    sb.delete(i-1,i+1);
                    i -= 2;
                } else {
                    stack.push(1);
                }
            }
        }
        return sb.toString();
    }
}