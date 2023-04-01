// Leetcode 2587: Rearrange Array to Maximize Prefix Score

public Solution2587 {
    // TC:O(NlogN), SC:O(1)
    public int maxScore(int[] nums) {
        Arrays.sort(nums);
        long sum = nums[nums.length-1];
        int ans = 0;
        for (int i = nums.length-2; i >= 0; i--) {
            if (sum <= 0) {
                break;
            }
            sum += nums[i];
            ans++;
        }
        return ans;
    }
}
