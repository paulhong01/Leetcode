// Leetcode 415: Add Strings
import java.util.*;

class Solution415 {
    public static void main(String[] args) {
        Solution415 sol = new Solution415();
        String res = sol.addStrings("13", "8");
        System.out.println(res);
    }

    public String addStrings(String num1, String num2) {
        // TC:O(n), SC:O(n)
        int n1 = num1.length(), n2 = num2.length();
        int[] temp = new int[Math.max(n1, n2) + 1];
        
        for (int i = 0; i < temp.length-1; i++) {
            int add = temp[i];
            if (n1 - i - 1 >= 0)    add += num1.charAt(n1-i-1) - '0';
            if (n2 - i - 1>= 0)    add += num2.charAt(n2-i-1) - '0';
            temp[i] = add % 10;
            temp[i+1] += add/10;
        }
        
        
        StringBuilder result = new StringBuilder();
        boolean startzero = true;
        for (int i = temp.length - 1; i >= 0; i--) {
            if (startzero && temp[i] == 0)  continue;
            else {
                startzero = false;
                result.append(temp[i]);
            }
        }
        return result.length() == 0?"0":result.toString();
    }
}