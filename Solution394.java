// Leetcode 394: Decode String
import java.util.*;

public class Solution394 {
    public static void main(String[] args) {
        // String s = "3[a]2[bc]";
        // String s = "3[a2[c]]";
        String s = "3[z]2[2[y]pq4[2[jk]e1[f]]]ef";

        Solution394 sol = new Solution394();
        String res = sol.decodeString(s);
        System.out.println(res);
    }

    public String decodeString(String s) {
        // Use stack
        StringBuilder cur = new StringBuilder();
        Stack<Integer> countstack = new Stack();
        Stack<StringBuilder> stringstack = new Stack();

        int indexstart = 0, index = 0, count = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                indexstart = index;
                while (Character.isDigit(s.charAt(index+1))) {
                    index++;
                }
                count = Integer.parseInt(s.substring(indexstart, index+1));
            } else if (s.charAt(index) == '[') {
                countstack.push(count);
                stringstack.push(cur);
                cur = new StringBuilder();
            } else if (s.charAt(index) == ']') {
                StringBuilder temp = new StringBuilder(stringstack.pop());
                int repeat = countstack.pop();

                for (int i = 0; i < repeat; i++) {
                    temp.append(cur);
                }
                cur = temp;
            } else {
                cur.append(s.charAt(index));
            }
            index++;
        }
        
        return cur.toString();
    }
}