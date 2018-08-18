// Leetcode 89: Gray Code
import java.util.*;

public class Solution89 {
    public static void main(String[] args) {
        int n = 2;

        Solution89 sol = new Solution89();
        List<Integer> res = sol.grayCode(n);
        System.out.println(res);
    }

    public List<Integer> grayCode(int n) {
        // We can observe the relationship between different n. The sequence of n is the reverse order of (n - 1) add 2^n.
        // We add the most significant bit in the reverse order of previous sequence, so the new sequence is still in gray code.
        // TC:O(2^n), SC:O(1)
        List<Integer> result = new ArrayList();
        if (n == 0) {
            result.add(0);
            return result;
        } 
        result.add(0);
        result.add(1);

        int pow = 1;
        for (int i = 1; i < n; i++) {
            pow <<= 1;
            int size = result.size();
            for (int idx = size - 1; idx >= 0; idx--) {
                result.add(result.get(idx) + pow);
            }
        }

        return result;
    }
}