// Leetcode 43: Multiply Strings
import java.util.*;

class Solution43 {

    public static void main(String[] args) {
        Solution43 sol = new Solution43();
        String res = sol.multiply("2", "5");
        System.out.println(res);
    }

    public String multiply(String num1, String num2) {
        // Method 1: Build in function
        // int n1 = Integer.valueOf(num1);
        // int n2 = Integer.valueOf(num2);
        // String result = String.valueOf(n1*n2);
        // return result;
        
        // Method 2:
        // TC:O(n), SC:O(n)
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m+n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = (num1.charAt(m - i - 1) - '0')*(num2.charAt(n-j-1) - '0');
                int p1 = i + j, p2 = i+j+1;
                int sum = temp + pos[p1];
                
                pos[p1] = sum % 10;
                pos[p2] += sum/10;
            }
        }
        
        StringBuilder result = new StringBuilder();
        boolean startzero = true;
        for (int i = m + n - 1; i >= 0; i--) {
            if (startzero && pos[i] == 0)   continue;
            else {
                startzero = false;
                result.append(pos[i]);
            }
        }
        
        return result.length()==0?"0":result.toString();
        
    }
}