// Leetcode 1823: Find the Winner of the Circular Game

class Solution1823 {
    public int findTheWinner(int n, int k) {
        // TC:O(N), SC:O(1)
        int res = 0;
        for (int i = 1; i <= n; ++i) {
            res = (res + k)%i;
        }
        return res+1;
    }
}