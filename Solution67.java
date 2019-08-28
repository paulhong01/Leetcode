// Leetcode 67: Add Binary
import java.util.*;

class Solution67 {
    public String addBinary(String a, String b) {
        String result = "";
        int idx1 = a.length()-1, idx2 = b.length()-1;
        int temp = 0;
        while (idx1 >= 0 || idx2 >= 0) {
            if (idx1 >= 0) {
                temp += a.charAt(idx1) - '0';
                idx1--;
            }
            if (idx2 >= 0) {
                temp += b.charAt(idx2) - '0';
                idx2--;
            }
            
            result = String.valueOf(temp%2)+result;
            temp /= 2;
        }
        if (temp != 0) {
            result = String.valueOf(temp)+result;
        }
        return result;
    }
}