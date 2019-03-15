// Leetcode 1005: Maximize Sum Of Array After K Negations
import java.util.*;

class Solution1005 {
    public int largestSumAfterKNegations(int[] A, int K) {
        Arrays.sort(A);
        for (int i = 0; i < A.length && K > 0 && A[i] < 0; i++, K--) {
            A[i] = -A[i];
        }
        
        int result = 0, minvalue = Integer.MAX_VALUE;
        for (int a: A) {
            result += a;
            minvalue = Math.min(minvalue, result);
        }
        
        return result - (K%2)*minvalue*2;
    }
}