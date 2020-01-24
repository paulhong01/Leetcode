// Leetcode 1323: Maximum 69 Number
import java.util.*;

class Solution1323 {
    public int maximum69Number (int num) {
        String num_str = String.valueOf(num);
        StringBuilder ret_str = new StringBuilder();
        boolean change = false;
        for (int i = 0; i < num_str.length(); i++) {
            if (num_str.charAt(i) == '6' && !change) {
                ret_str.append('9');
                change = true;
            } else {
                ret_str.append(num_str.charAt(i));
            }
        }
        return Integer.valueOf(ret_str.toString());
    }
}