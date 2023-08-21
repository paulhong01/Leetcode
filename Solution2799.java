// Leetcode 2799: Count Complete Subarrays in an Array

class Solution2799 {
    public int countCompleteSubarrays(int[] nums) {
        // TC:O(N), SC:O(N)
        Map<Integer, Integer> freq = new HashMap<Integer, Integer>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }

        Map<Integer, Integer> cur_freq = new HashMap<Integer, Integer>();
        int left = 0, right = 0, ret = 0;
        while (right < nums.length) {
            cur_freq.put(nums[right], cur_freq.getOrDefault(nums[right], 0) + 1);
            while (left <= right && cur_freq.size() == freq.size()) {
                ret += (nums.length - right);
                cur_freq.put(nums[left], cur_freq.get(nums[left]) - 1);
                if (cur_freq.get(nums[left]) == 0) {
                    cur_freq.remove(nums[left]);
                }
                ++left;
            }
            ++right;
        }
        return ret;
    }
}
