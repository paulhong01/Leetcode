// Leetcode 482: License Key Formatting
import java.util.*;

public class Solution482 {
    public static void main(String[] args) {
        String S = "--a--a";
        int K = 2;

        Solution482 sol = new Solution482();
        String res = sol.licenseKeyFormatting(S, K);
        System.out.println(res);
    }

    public String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "");
        char[] S_arr = S.toUpperCase().toCharArray();
        StringBuilder tempresult = new StringBuilder();
        int count = 0;
        for (int i = S_arr.length - 1; i >=0; i--) {
            if (S_arr[i] == '-') {
                continue;
            }
            count++;
            tempresult.append(S_arr[i]);
            if (count == K && i != 0) {
                tempresult.append('-');
                count = 0;
            }
        }
        return tempresult.reverse().toString();
    }
}