// Leetcode 977: Squares of a Sorted Array
import java.util.*;

class Solution977 {
    public int[] sortedSquares(int[] A) {
        // Method 1: Sorting, TC:O(nlog(n)), SC:O(1)
        // for (int i = 0; i < A.length; i++) {
        //     A[i] = A[i]*A[i];
        // }
        // Arrays.sort(A);
        // return A;
        
        // Method 2: two pointers, TC:O(n), SC:O(n)
        int N = A.length;
        int[] result = new int[N];
        int i = 0, j = 0;
        
        while (j < N && A[j] < 0) {
            j++;
        }
        
        i = j - 1;
        int cur = 0;
        while (i >= 0 && j < N) {
            if (A[i]*A[i] < A[j]*A[j]) {
                result[cur++] = A[i]*A[i];
                i--;
            } else {
                result[cur++] = A[j]*A[j];
                j++;
            }
        }
        
        while (i >= 0) {
            result[cur++] = A[i]*A[i];
            i--;
        }
        
        while (j < N) {
            result[cur++] = A[j]*A[j];
            j++;
        }
        return result;
    }
}