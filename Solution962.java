// Leetcode 962: Maximum Width Ramp
import java.util.*;

class Solution962 {
    public static void main(String[] args) {
        int[] A = {6,0,8,2,1,5};
        Solution962 sol = new Solution962();
        int res = sol.maxWidthRamp(A);
        System.out.println(res);
    }
    public int maxWidthRamp(int[] A) {
        // Method 1: Brute force
        // TC:O(n^2), SC:O(1)
        // int maxwidth = A.length-1;
        // for (; maxwidth >= 0; maxwidth--) {
        //     for (int start = 0; start+maxwidth < A.length; start++) {
        //         if (A[start] <= A[start+maxwidth]) {
        //             return maxwidth;
        //         }
        //     }
        // }
        // return 0;

        // Method 2:  Stack
        // TC:O(n), SC:O(n)
        Stack<Integer> stack = new Stack();
        int n = A.length;
        for (int i = 0; i < n; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }
        int result = 0;
        for (int i = n - 1; i >= result; i--) {
            while (!stack.isEmpty() && A[stack.peek()] <= A[i])  result = Math.max(result, i - stack.pop());
        }
        return result;
    }
} 