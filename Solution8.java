//Leetcode 8: String to Integer (atoi)
import java.util.*;

public class Solution8 {
    public static void main(String[] args) {
        String str = "   +0 123";

        Solution8 sol = new Solution8();
        int res = sol.myAtoi(str);
        System.out.println(res);
    }

    public int myAtoi(String str) {
        // TC:O(n), SC:O(1)
        boolean add = true;
        boolean first = true;
        int result = 0;
        for (char c: str.toCharArray()) {
            if (first && c == ' ')   continue;
            else if (first && c == '+') {
                first = false;
                add = true;
            }
            else if (first && c == '-') {
                first = false;
                add = false;
            }
            else if (Character.isDigit(c)) {
                first = false;
                int temp = c - '0';
                if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7))  return Integer.MAX_VALUE;
                else if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && temp > 8)) return Integer.MIN_VALUE;
                else {
                    result *= 10;
                    result += (add)?temp:temp*(-1);
                }
            } else {
                return result;
            }
        }

        return result;
    }
}