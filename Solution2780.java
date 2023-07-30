// Leetcode 2780: Minimum Index of a Valid Split

class Solution2780 {
    public int minimumIndex(List<Integer> nums) {
        // TC:O(N), SC:O(1)
        int dominant = nums.get(0), count = 1;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i) != dominant) {
                --count;
            } else {
                ++count;
            }

            if (count == 0) {
                dominant = nums.get(i);
                count = 1;
            }
        }

        int dominant_freq = 0;
        for (int num : nums) {
            if (num == dominant) {
                ++dominant_freq;
            }
        }

        count = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == dominant) {
                count++;
            }
            if ((count*2 > (i+1)) && (dominant_freq - count)*2 > (nums.size()-i-1)) {
                return i;
            }
        }
        return -1;
    }
}
