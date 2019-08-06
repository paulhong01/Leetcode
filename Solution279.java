// Leetcode 279: Perfect Squares
import java.util.*;

class Solutio279n {
    public int numSquares(int n) {
//         if (n < 4) {
//             return n;
//         }
        
//         int temp_min = n;
//         for (int i = 1; i*i <= n; i++) {
//             temp_min = Math.min(temp_min, numSquares(n-i*i)+1);
//         }
//         return temp_min;
        // dp[n]: least number of perfect square numbers which sum to n
        // TC:O(N), SC:O(N)
        if (n < 4) {
            return n;
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, n);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j*j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j*j]+1);
            }
        }
        return dp[n];
    }
}