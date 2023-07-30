// Leetcode 2778: Sum of Squares of Special Elements

class Solution2778 {
    public int sumOfSquares(int[] nums) {
        // TC:O(N), SC:O(1)
        int N = nums.length;
        int ret = 0;
        for (int i = 1; i <= N; i++) {
            if (N%i != 0) {
                continue;
            }
            ret += (nums[i-1]*nums[i-1]);
        }
        return ret;
    }
}
