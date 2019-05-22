// Leetcode 992: Subarrays with K Different Integers
import java.util.*;

class Solution992 {
    public int subarraysWithKDistinct(int[] A, int K) {
        // TC:O(N), SC:O(N)
        return atMost(A, K) - atMost(A, K-1);
    }
    
    private int atMost(int[] A, int K) {
        int l = 0, r = 0;
        int N = A.length;
        if (N*K == 0)   return 0;
        
        Map<Integer, Integer> map = new HashMap();
        int ret = 0;
        while (r < N) {
            map.put(A[r], r++);
            
            
            if (map.size() == K+1) {
                int del_idx = Collections.min(map.values());
                map.remove(A[del_idx]);
                l = del_idx+1;
            } 
            ret += (r-l);
        }
        return ret;
    }
}