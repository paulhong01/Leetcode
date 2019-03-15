// Leetcode 989: Add to Array-Form of Integer
import java.util.*;

class Solution989 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        // TC:O(max(N, logK)), SC:O(max(N,logK)), where N = A.length, 
        List<Integer> result = new ArrayList();
        int carry = 0;
        if (A.length == 0 && K == 0) {
            result.add(0);
            return result;
        }
        for (int i = A.length - 1; i >= 0; i--) {
            int sum = carry + A[i] + K%10;
            K /= 10;
            result.add(sum%10);
            carry = sum/10;
        }
        while (K > 0) {
            int sum = carry + K%10;
            K /= 10;
            result.add(sum % 10);
            carry = sum/10;
        }
        if (carry > 0)  result.add(carry);
        
        Collections.reverse(result);
        return result;
    }
}