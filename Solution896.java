// Leetcode 896: Monotonic Array
import java.util.*;

class Solution896 {
    public boolean isMonotonic(int[] A) {
        Boolean isincreasing = null;
        for (int i = 1; i < A.length; i++) {
            if (isincreasing != null && isincreasing && A[i] < A[i-1])  return false;
            else if (isincreasing != null && !isincreasing && A[i] > A[i-1])    return false;
            if (isincreasing == null && A[i] != A[i-1]) {
                isincreasing = (A[i] > A[i-1]);
            }
        }
        return true;
    }
}