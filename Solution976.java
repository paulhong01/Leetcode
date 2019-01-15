// Leetcode 976: Largest Perimeter Triangle
import java.util.*;

class Solution976 {
    public static void main(String[] args) {
        int[] A = {2, 1, 2};
        Solution976 sol = new Solution976();
        int res = sol.largestPerimeter(A);
        System.out.println(res);
    }

    public int largestPerimeter(int[] A) {
        // TC:O(nlog(n)), SC:O(1)
        Arrays.sort(A);
        for (int i = A.length - 3; i >= 0; --i)
            if (A[i] + A[i+1] > A[i+2])
                return A[i] + A[i+1] + A[i+2];
        return 0;
    }
}