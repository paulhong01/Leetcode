// Leetcode 1374: Generate a String With Characters That Have Odd Counts
import java.util.*;

class Solution1374 {
    public String generateTheString(int n) {
        // TC:O(N), SC:O(N)
        StringBuilder ret = new StringBuilder();
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                ret.append('a');
            }
            return ret.toString();
        } else {
            ret.append('a');
            for (int i = 1; i < n; i++) {
                ret.append('b');
            }
            return ret.toString();
        }
    }
}