//Leetcode 344: Reverse String
import java.util.*;

public class Solution344{
    public static void main(String args[]){
        String S = "hello";
        Solution344 s = new Solution344();
        String result = s.reverseString(S);
        System.out.println(result);
    }

    public String reverseString(String s) {
        // Use two pointers, TC: O(N), SC: O(1)
        char c[] = s.toCharArray();
        int l = 0, r = s.length()-1;
        while (l < r){
            char temp = c[l];
            c[l++] = c[r];
            c[r--] = temp;
        }
        return new String(c);
    }
}