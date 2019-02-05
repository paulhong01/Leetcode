// Leetcode 985: Sum of Even Numbers After Queries
import java.util.*;

class Solution985 {
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        // TC:O(N+Q), SC:O(N+Q)
        int sum = 0;
        for (int a: A) {
            if (a % 2 == 0) {
                sum += a;
            } 
        }
        
        int[] result = new int[queries.length];
        int idx = 0;
        for (int[] q: queries) {
            if (A[q[1]] % 2 == 0)   sum -= A[q[1]];
            A[q[1]] += q[0];
            if (A[q[1]] % 2 == 0)   sum += A[q[1]];
            result[idx++] = sum;
        }
        return result;
    }
}