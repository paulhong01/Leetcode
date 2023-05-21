// Leetcode 2656: Maximum Sum With Exactly K Elements

class Solution2656 {
    public int maximizeSum(int[] nums, int k) {
        // TC:O(N), SC:O(1)
        int max_value = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max_value = Math.max(max_value, nums[i]);
        }

        return max_value*k + (k)*(k-1)/2;
    }
}
