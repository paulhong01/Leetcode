// Leetcode 1281: Subtract the Product and Sum of Digits of an Integer
import java.util.*;

class Solution1281 {
    public int subtractProductAndSum(int n) {
        // TC:O(N), SC:O(N)
        String str = String.valueOf(n);
        int product = 1, sum = 0;
        for (int i = 0; i < str.length(); i++) {
            product *= str.charAt(i) - '0';
            sum += str.charAt(i) - '0';
        }
        return product - sum;
    }
}