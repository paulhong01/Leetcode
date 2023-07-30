// Leetcode 2779: Maximum Beauty of an Array After Applying Operation

class Solution2779 {
    public int maximumBeauty(int[] nums, int k) {
        // TC:O(NlogN), SC:O(1)
        Arrays.sort(nums);
        int start = 0, ans = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i]-nums[start] > 2*k) {
                start++;
            }
            ans = Math.max(ans, i-start+1);
        }
        return ans;
    }
}
