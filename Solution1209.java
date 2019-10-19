// Leetcode 1209: Remove All Adjacent Duplicates in String II
import java.util.*;

class Solution1209 {
    public String removeDuplicates(String s, int k) {
        // Method 1: Brute force TC:O(n^2/k), SC:O(1)
        // StringBuilder sb = new StringBuilder(s);
        // int length = -1;
        // while (length != sb.length()) {
        //     length = sb.length();
        //     for (int i = 0, count = 1; i < sb.length(); i++) {
        //         if (i == 0 || sb.charAt(i-1) != sb.charAt(i)) {
        //             count = 1;
        //         } else {
        //             count++;
        //             if (count == k) {
        //                 sb.delete(i-k+1, i+1);
        //                 break;
        //             }
        //         }
        //     }
        // } 
        // return sb.toString();
        
        // Method 2: Stack, TC:O(n), SC:O(n)
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < sb.length(); i++) {
            if (i == 0 || sb.charAt(i-1) != sb.charAt(i)) {
                stack.push(1);
            } else {
                int update = stack.pop()+1;
                if (update == k) {
                    sb.delete(i-k+1, i+1);
                    i = i - k;
                } else {
                    stack.push(update);
                }
            }
        }
        return sb.toString();
    }
}