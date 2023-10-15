// Leetcode 2848: Points That Intersect With Cars

class Solution2848 {
    public int numberOfPoints(List<List<Integer>> nums) {
        // TC:O(N^2), SC:O(1)
        boolean[] has_value = new boolean[101];
        for (List<Integer> num : nums) {
            for (int idx = num.get(0); idx <= num.get(1); ++idx) {
                has_value[idx] = true;
            }
        }

        int ret = 0;
        for (int i = 0; i < 101; i++) {
            if (has_value[i]) {
                ++ret;
            }
        }
        return ret;
    }
}
