// Leetcode 2850: Minimum Moves to Spread Stones Over Grid

class Solution2850 {
    public int minimumMoves(int[][] grid) {
        // TC:O(N^2), SC:O(1)
        // Base Case
        int t = 0;
        for (int i = 0; i < 3; ++i)
            for (int j = 0; j < 3; ++j)
                if (grid[i][j] == 0)
                    t++;
        if (t == 0)
            return 0;

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (grid[i][j] == 0) {
                    for (int ni = 0; ni < 3; ++ni) {
                        for (int nj = 0; nj < 3; ++nj) {
                            int d = Math.abs(ni - i) + Math.abs(nj - j);
                            if (grid[ni][nj] > 1) {
                                grid[ni][nj]--;
                                grid[i][j]++;
                                ans = Math.min(ans, d + minimumMoves(grid));
                                grid[ni][nj]++;
                                grid[i][j]--;
                            }
                        }
                    }
                }
            }
        }
        return ans;
    }
}
