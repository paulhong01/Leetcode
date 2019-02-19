// Leetcode 995: Minimum Number of K Consecutive Bit Flips
import java.util.*;

class Solution995 {
    public int minKBitFlips(int[] A, int K) {
        // Greedy: TC:O(n), SC:O(1)
        int n = A.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (A[i] == 0 && i + K <= n) {
                ans++;
                for (int j = 0; j < K; j++) {
                    A[i+j] = 1 - A[i+j];
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (A[i] == 0)  return -1;
        }
        return ans;
    }
} 