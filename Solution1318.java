// Leetcode 1318: Minimum Flips to Make a OR b Equal to c
import java.util.*;

class Solution1318 {
    public int minFlips(int a, int b, int c) {
        // TC:O(1), SC:O(1)
        int ans = 0, ab = a | b, equal = ab ^ c;
        for (int i = 0; i < 31; i++) {
            int mask = 1 << i;
            if ((equal & mask) > 0) {
                ans += (ab & mask) < (c & mask) || (a & mask) != (b & mask)?1:2;
            }
        }
        return ans;
    }
}