// Leetcode 670: Maximum Swap
import java.util.*;

class Solution670 {
    public int maximumSwap(int num) {
        // TC:O(N), SC:(N)
        String num_string = String.valueOf(num);
        char[] num_chars = num_string.toCharArray();
        int[] last = new int[10];
        for (int i = 0; i < num_chars.length; i++) {
            last[num_chars[i]-'0'] = i;
        }
        
        for (int i = 0; i < num_chars.length; i++) {
            for (int j = 9; j > num_chars[i]-'0'; j--) {
                if (last[j] > i) {
                    num_chars[last[j]] = num_chars[i];
                    num_chars[i] = (char)(j+'0');
                    String update = new String(num_chars);
                    return Integer.valueOf(update);
                }
            }
        }
        return num;
    }
}