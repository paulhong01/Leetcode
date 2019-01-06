// Leetcode 969: Pancake Sorting
import java.util.*;

class Solution969 {
    public static void main(String[] args) {
        int[] A = {3,2,4,1};
        Solution969 sol = new Solution969();
        List<Integer> res = sol.pancakeSort(A);
        System.out.println(res);
    }

    public List<Integer> pancakeSort(int[] A) {
        // TC:O(n^2), SC:O(n)
        List<Integer> result = new ArrayList();
        if (A == null || A.length < 2)  return result;
        
        int end = A.length - 1;
        while (end > 0) {
            int currentmax = findCurrentMax(A, end);
            if (currentmax != end) {
                flip(A, 0, currentmax);
                result.add(currentmax + 1);
                flip(A, 0, end);
                result.add(end + 1);
            }
            
            end--;
        }
        return result;
    }
    
    private int findCurrentMax(int[] A, int end) {
        int maxvalue = A[0];
        int maxidx = 0;
        for (int i = 1; i <= end; i++) {
            if (A[i] > maxvalue) {
                maxvalue = A[i];
                maxidx = i;
            }
        }
        return maxidx;
    }
    
    private void flip(int[] A, int start, int end) {
        while (start < end) {
            int temp = A[start];
            A[start++] = A[end];
            A[end--] = temp;
        }
    }
    
}