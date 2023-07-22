// Leetcode 2750: Ways to Split Array Into Good Subarrays

class Solution2750 {
    public int numberOfGoodSubarraySplits(int[] nums) {
        // TC:O(N), SC:O(1)
        long ans = 1, m = 1000000007, count  = 0;
        int idx = 0;
        while (idx < nums.length && nums[idx] == 0) {
            idx++;
        }
        if (idx == nums.length) {
            return 0;
        }

        for (; idx < nums.length; idx++) {
            if (nums[idx] == 1) {
                ans = (ans * (count+1))%m;
                count = 0;
            } else {
                count++;
            }
        } 
        return (int)ans;
    }
}
