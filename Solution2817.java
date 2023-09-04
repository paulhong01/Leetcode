// Leetcode 2817: Minimum Absolute Difference Between Elements With Constraint

class Solution2817 {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        // TC:O(NlogN), SC:O(1)
        int ans = Integer.MAX_VALUE;
        TreeSet<Integer> s = new TreeSet<>();
        for(int i = x; i < nums.size(); ++i){
            s.add(nums.get(i-x));
            Integer high = s.ceiling(nums.get(i)), low = s.floor(nums.get(i));
            if(high != null) ans = Math.min(ans, Math.abs(nums.get(i) - high));
            if(low != null) ans = Math.min(ans, Math.abs(nums.get(i) - low));
        }
        return ans;
    }
}
