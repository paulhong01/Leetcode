// Leetcode 166: Fraction to Recurring Decimal
import java.util.*;

class Solution166 {
    public String fractionToDecimal(int numerator, int denominator) {
        // TC:O(N), SC:O(N)
        if (numerator == 0) return "0";
        
        StringBuilder result = new StringBuilder();
        result.append(((numerator>0)^(denominator>0))?"-":"");
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        
        result.append(num/den);
        num %= den;
        if (num == 0) {
            return result.toString();
        }
        
        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        map.put(num, result.length());
        while (num != 0) {
            num *= 10;
            result.append(num/den);
            num %= den;
            if (map.containsKey(num)) {
                int idx = map.get(num);
                result.insert(idx, "(");
                result.append(")");
                break;
            } else {
                map.put(num, result.length());
            }
        }
        return result.toString();
    }
}