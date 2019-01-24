// Leetcode 201: Bitwise AND of Numbers Range
import java.util.*;

public class Solution201 {
    public static void main(String[] args) {
        int m = 5;
        int n = 7;
        Solution201 sol = new Solution201();
        int res = sol.rangeBitwiseAnd(m, n);
        System.out.println(res);
    }

    public int rangeBitwiseAnd(int m, int n) {
        int bits = 0;
        while (m != n) {
            m >>= 1;
            n >>= 1;
            bits++;
        }
        return m<<bits;
    }
}