// Leetcode 1014: Capacity To Ship Packages Within D Days
import java.util.*;

class Solution1011 {
    public int shipWithinDays(int[] weights, int D) {
        // Binary search: TC:O(Nlog(W)), SC:O(1)
        int l = weights[0], r = weights[0];
        for (int i = 1; i < weights.length; i++) {
            if (weights[i] > l) l = weights[i];
            r += weights[i];
        }
        
        int result = r;
        while (l <= r) {
            int m = l + (r - l)/2;
            int count = 1, sum = 0;
            for (int w: weights) {
                if (sum + w > m) {
                    count++;
                    sum = w;
                } else {
                    sum += w;
                }
            }
            // System.out.printf("%d %d\n", m, count);
            if (count <= D) {
                result = Math.min(result, m);
                r = m - 1;
            } else {
                l = m + 1;
            }
            
        }
        
        return result;
    }
}