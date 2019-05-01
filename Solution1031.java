// Leetcode 1031: Maximum Sum of Two Non-Overlapping Subarrays
import java.util.*;

class Solution1031 {
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
        // Prefix sum: TC:O(N), SC:O(N)
        int len = A.length;
        int[] prefix = new int[len];
        prefix[0] = A[0];
        for (int i = 1; i < len; i++) {
            prefix[i] = prefix[i-1]+A[i];
        }
        
        int res = 0;
        int Lmax = prefix[L-1], Mmax = prefix[M-1];
        
        for (int i = 0; i < len; i++) {
            if (i >= L && i+M-1<len) {
                res = Math.max(res, Lmax + prefix[i+M-1] - prefix[i-1]);
            }
            
            if (i >= M && i+L-1<len) {
                res = Math.max(res, Mmax+prefix[i+L-1]-prefix[i-1]);
            }
            
            if (i >= L) {
                Lmax = Math.max(Lmax, prefix[i]-prefix[i-L]);
            }
            
            if (i >= M) {
                Mmax = Math.max(Mmax, prefix[i]-prefix[i-M]);
            }
        }
        return res;
        
        
    }
}