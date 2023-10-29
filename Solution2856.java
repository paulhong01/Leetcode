// Leetcode 2856: Minimum Array Length After Pair Removals

class Solution2856 {
    public int minLengthAfterRemovals(List<Integer> nums) {
        // TC:O(N), SC:O(1)
        int max_freq = 0, cur_freq = 1;
        for (int i = 1; i < nums.size(); ++i) {
            if (nums.get(i) != nums.get(i-1)) {
                max_freq = Math.max(max_freq, cur_freq);
                cur_freq = 1;
                continue;
            }
            ++cur_freq;
            System.out.println(cur_freq);
        }
        max_freq = Math.max(max_freq, cur_freq);
        if (max_freq <= nums.size()/2) {
            return nums.size()%2;
        }
        return 2*max_freq - nums.size();
    }
}
