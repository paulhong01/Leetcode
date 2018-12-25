// Leetcode 541: Reverse String II
import java.util.*;

class Solution541 {

    public static void main(String[] args) {
        Solution541 sol = new Solution541();
        String s = "abcdefg";
        int k = 2;
        String res = sol.reverseStr(s, k);
        System.out.println(res);
    }
    
    public String reverseStr(String s, int k) {
        // TC:O(n), SC:O(n)
        // a, b, c, d, e, f, g
        // 0, 1, 2, 3, 4, 5, 6
        // 1. r = k - 1, l = 0
        // 2. r = 3*k - 1, l = 2*k
        char[] c_arr = s.toCharArray();
        int r = k - 1 >= s.length()?s.length()-1:(k-1);
        int l = 0;
        int time = 0;
        while (l < s.length() && r < s.length()) {
            // Reverse k
            while (l < r) {
                char temp = c_arr[l];
                c_arr[l++] = c_arr[r];
                c_arr[r--] = temp;
            }
            
            time += 2;
            l = time * k;
            r = (time + 1)*k - 1 >= s.length()? s.length()-1:(time + 1)*k - 1 ;
        }
        return String.valueOf(c_arr);
    }
}