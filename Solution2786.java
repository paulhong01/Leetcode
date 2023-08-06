// Leetcode 2786: Visit Array Positions to Maximize Score

public class Solution2786 {
    public long maxScore(int[] nums, int x) {
        // TC:O(N), SC:O(1)
        int N = nums.length;
        long even = nums[0] - ((nums[0] % 2 == 1)? x : 0);
        long odd = nums[0] - ((nums[0] % 2 == 1)? 0:x);
        for (int i = 1; i < N; i++) {
            if (nums[i] % 2 == 1) {
                odd = nums[i] + Math.max(odd, even - x);
            } else {
                even = nums[i] + Math.max(even, odd - x);
            }
        }
        return Math.max(even, odd);
    }
    
}
