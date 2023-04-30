// Leetcode 2611: Mice and Cheese

public class Solution2611 {

    public int miceAndCheese(int[] A, int[] B, int k) {
        // TC:O(NlogN), SC:O(N)
        int res = 0, n = A.length, diff[] = new int[n];
        for (int i = 0; i < n; i++) {
            diff[i] = A[i] - B[i];
            res += B[i];
        }
        Arrays.sort(diff);
        for (int i = 0; i < k; i++)
            res += diff[n - 1 - i];
        return res;
    }
    
}
