// Leetcode 2830: Maximize the Profit as the Salesman

class Solution2830 {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        // TC:O(N), SC:O(N)
        int[] dp = new int[n+1];
        List<List<List<Integer>>> m = new ArrayList<List<List<Integer>>>();
        for (int i = 0; i < n; i++) {
            m.add(new ArrayList<List<Integer>>());
        }

        for (List<Integer> offer : offers) {
            m.get(offer.get(1)).add(offer);
        }

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i-1];
            for (List<Integer> offer : m.get(i-1)) {
                dp[i] = Math.max(dp[i], dp[offer.get(0)]+offer.get(2));
            }
        }
        return dp[n];
    }
}
