// Leetcode 961: N-Repeated Element in Size 2N Array
import java.util.*;

class Solution961 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 3};
        Solution961 sol = new Solution961();
        int res = sol.repeatedNTimes(A);
        System.out.println(res);
    }

    public int repeatedNTimes(int[] A) {
        // Method 1: HashMap
        // TC:O(n), SC:O(n)
        // Map<Integer, Integer> map = new HashMap();
        // for (int n: A) {
        //     int freq = map.getOrDefault(n, 0) + 1;
        //     if (freq >= A.length/2) return n;
        //     map.put(n, freq);
        // }
        // return -1;

        // Method 2: 
        // If a number is repeated N times in a list of size 2N, it is always possible for the repeated number to stay within a distance of 2.
        // TC:O(n), SC:O(1)
        for (int i = 2; i < A.length; i++) {
            if (A[i] == A[i-1] || A[i] == A[i-2])   return A[i];
        }
        return A[0];
    }
}