// Leetcode 2615: Sum of Distances

class Solution2615 {
    public long[] distance(int[] nums) {
        // TC:O(N), SC:O(N)
        long[] ret = new long[nums.length];
        Map<Integer, Long> sum_l = new HashMap<Integer, Long>();
        Map<Integer, Long> cnt_l = new HashMap<Integer, Long>();
        for (int i = 0; i < nums.length; i++) {
            ret[i] += cnt_l.getOrDefault(nums[i], (long)0)*i - sum_l.getOrDefault(nums[i], (long)0);
            sum_l.put(nums[i], sum_l.getOrDefault(nums[i], (long)0) + i);
            cnt_l.put(nums[i], cnt_l.getOrDefault(nums[i], (long)0) + 1);
        }

        Map<Integer, Long> sum_r = new HashMap<Integer, Long>();
        Map<Integer, Long> cnt_r = new HashMap<Integer, Long>();
        for (int i = nums.length-1; i >= 0; i--) {
            ret[i] += sum_r.getOrDefault(nums[i], (long)0) - cnt_r.getOrDefault(nums[i], (long)0)*i;
            sum_r.put(nums[i], sum_r.getOrDefault(nums[i], (long)0) + i);
            cnt_r.put(nums[i], cnt_r.getOrDefault(nums[i], (long)0) + 1);
        }
        return ret;
    }
}
