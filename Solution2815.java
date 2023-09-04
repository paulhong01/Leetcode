// Leetcode 2815: Max Pair Sum in an Array

class Solution2815 {
    public int maxSum(int[] nums) {
        // TC:O(N^2), SC:O(1)
        int ret = -1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (MaxDigit(nums[i]) == MaxDigit(nums[j])) {
                    ret = Math.max(ret, nums[i] + nums[j]);
                }
            }
        }
        return ret;
    }

    private int MaxDigit(int num) {
        int max_digit = num%10;
        while (num != 0) {
            max_digit = Math.max(max_digit, num%10);
            num /= 10;
        }
        return max_digit;
    }
}
