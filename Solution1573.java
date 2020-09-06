// Leetcode 1573: Number of Ways to Split a String
import java.util.*;

class Solution1573 {
    private static final int m = 1_000_000_007;
    public int numWays(String s) {
        // TC:O(N), SC:O(1)
        int ones = 0, n = s.length();
        for (int i = 0; i < n; ++i) {
            ones += s.charAt(i) - '0';
        }
        if (ones == 0) {
            return (int)((n - 2L) * (n - 1L) / 2 % m);
        }
        if (ones % 3 != 0) {
            return 0;
        }
        int onesInEachSplitedBlock = ones / 3;
        long waysOfFirstCut = 0, waysOfSecondCut = 0;
        for (int i = 0, count = 0; i < n; ++i) {
            count += s.charAt(i) - '0';
            if (count == onesInEachSplitedBlock) {
                ++waysOfFirstCut;
            }else if (count == 2 * onesInEachSplitedBlock) {
                ++waysOfSecondCut;
            }
        }
        return (int)(waysOfFirstCut * waysOfSecondCut % m);        
    }
}
