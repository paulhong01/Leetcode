// Leetcode 1340: Jump Game V
import java.util.*;

class Solution1340 {
    public int maxJumps(int[] arr, int d) {
    int n = arr.length;
    int dp[] = new int[n];
    int res = 1;
    for (int i = 0; i < n; ++i)
        res = Math.max(res, dfs(arr, n, d, i, dp));
    return res;
    }

    private int dfs(int[] arr, int n, int d, int i, int[] dp) {
        if (dp[i] != 0) return dp[i];
        int res = 1;
        for (int j = i + 1; j <= Math.min(i + d, n - 1) && arr[j] < arr[i]; ++j)
            res = Math.max(res, 1 + dfs(arr, n, d, j, dp));
        for (int j = i - 1; j >= Math.max(i - d, 0) && arr[j] < arr[i]; --j)
            res = Math.max(res, 1 + dfs(arr, n, d, j, dp));
        return dp[i] = res;
    }
}