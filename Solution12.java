// Leetcode 12: Integer to Roman
import java.util.*;

public class Solution12 {
    public static void main(String[] args) {
        int num = 58;

        Solution12 sol = new Solution12();
        String res = sol.intToRoman(num);
        System.out.println(res);
    }

    public String intToRoman(int num) {
        // TC:O(1), SC:O(1)
        // Create corresponding value, symbol pair
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbol = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            while (num >= value[i]) {
                result.append(symbol[i]);
                num -= value[i];
            }
        }
        return result.toString();
    }
}