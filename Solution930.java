// Leetcode 930: Binary Subarrays With Sum
import java.util.*;

class Solution930 {
   
    public static void main(String[] args) {
        Solution930 sol = new Solution930();
        int[] A = {1, 0, 1, 0, 1};
        int S = 2;
        int res = sol.numSubarraysWithSum(A, S);
        System.out.println(res);
    }
    
    public int numSubarraysWithSum(int[] A, int S) {
        // Method 1: Brute force
        // int result = 0;
        // for (int i = 0; i < A.length; i++) {
        //     int tempresult = 0;
        //     for (int j = i; j < A.length; j++) {
        //         tempresult += A[j];
        //         if (tempresult == S)    result++;
        //     }
        // }
        // return result;
        
        // Method 2: Prefixsum, similar to question 560
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        int result = 0;
        int prefixsum = 0;
        for (int n: A) {
            prefixsum += n;
            result += map.getOrDefault(prefixsum - S, 0);
            map.put(prefixsum, map.getOrDefault(prefixsum, 0)+1);
        }
        return result;
    }
} 