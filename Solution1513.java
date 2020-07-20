// Leetcode 1513: Number of Substrings With Only 1s
import java.util.*;

class Solution1513 {
    public int numSub(String s) {
        // TC:O(N), SC:O(1)
        int ret = 0, count = 0, mod = (int)1e9 + 7;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                count++;
            } else {
                count = 0;
            }
            ret = (ret + count)%mod;
        }
        return ret;
    }
}