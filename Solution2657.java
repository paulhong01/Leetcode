// Leetcode 2657: Find the Prefix Common Array of Two Arrays

class Solution2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        // TC:O(N), SC:O(N)
        int count = 0, N = A.length;
        int[] seen = new int[N];
        int[] ret = new int[N];
        for (int i = 0; i < N; i++) {
            seen[A[i]-1]++;
            if (seen[A[i]-1] == 2) {
                count++;
            }
            seen[B[i]-1]++;
            if (seen[B[i]-1] == 2) {
                count++;
            }
            ret[i] = count;
        }
        return ret;
    }
}
