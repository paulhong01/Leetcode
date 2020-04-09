// Leetcode 1404: Number of Steps to Reduce a Number in Binary Representation to One
import java.util.*;

class Solution1404 {
    public int numSteps(String s) {
        // TC:O(N), SC:O(1)
        int res = 0, carry = 0;
        for (int i = s.length() - 1; i > 0; --i) {
            ++res;
            if (s.charAt(i) - '0' + carry == 1) {
                carry = 1;
                ++res;
            }
        }
        return res + carry;
    }
}