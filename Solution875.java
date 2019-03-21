// Leetcode 875: Koko Eating Bananas
import java.util.*;

class Solution875 {
    public int minEatingSpeed(int[] piles, int H) {
        // TC:O(Nlog(W)), SC:O(1)
        long l = 1;
        long r = piles[0];
        for (int i = 1; i < piles.length; i++) {
            //if (piles[i] < l)   l = piles[i];
            r += piles[i];
        }
        
        long result = r;
        while (l <= r) {
            long m = l + (r - l)/2;
            // System.out.println(m);
            long count = 0;
            for (int p: piles) {
                count += (int)Math.ceil(p/(double)m);
            }
            if (count <= H) {
                result = Math.min(result, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return (int)result;
    }
}