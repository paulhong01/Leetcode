// Leetcode 1915: Number of Wonderful Substrings
import java.util.*;

class Solution1915 {
    public long wonderfulSubstrings(String word) {
        // TC:O(N), SC:O(N)
        long[] count = new long[1024];
        count[0] = 1;
        int mask = 0;
        long res = 0;
        for (char c : word.toCharArray()) {
            mask ^= (1 << (c - 'a'));
            res += count[mask];
            for (int i = 0; i < 10; i++) {
                int lookfor = mask ^ (1 << i);
                res += count[lookfor];
            }
            count[mask]++;
        }
        return res;
    }
}