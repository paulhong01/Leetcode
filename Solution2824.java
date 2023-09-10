// Leetcode 2824: Count Pairs Whose Sum is Less than Target


class Solution2824 {
    public int countPairs(List<Integer> nums, int target) {
        // TC:O(NlogN), SC:O(1)
        Collections.sort(nums);
        int l = 0, r = nums.size()-1;
        int count = 0;
        while (l < r) {
            if (nums.get(l) + nums.get(r) < target) {
                count += (r - l);
                l++;
            } else {
                r--;
            }
        }
        return count;
    }
}
