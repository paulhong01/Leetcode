// Leetcode 1022: Smallest Integer Divisible by K
import java.util.*;

class Solution1022 {
    public int smallestRepunitDivByK(int K) {
        // TC:O(1), SC:O(1)
        if (K%2 == 0 || K%5 == 0)    return -1;
        int r = 0;
        for (int i = 1; i <= K; i++) {
            r = (r*10+1)%K;
            if (r == 0) return i;
        }
        return -1;
    }
}