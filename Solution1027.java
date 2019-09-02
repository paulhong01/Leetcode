// Leetcode 1027: Longest Arithmetic Sequence
import java.util.*;

class Solution1027 {
    public int longestArithSeqLength(int[] A) {
        // Dynamic programming, TC:O(N^2), SC:O(N)
        int N = A.length;
        HashMap<Integer, Integer>[] dp = new HashMap[N];
        int ret = 0;
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1)+1);
                ret = Math.max(ret, dp[i].get(diff));
            }
        }
        return ret;
    }
}