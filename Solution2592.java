// Leetcode 2592: Maximize Greatness of an Array

public class Solution2592 {
    public int maximizeGreatness(int[] nums) {
        // TC:(NlogN), SC:O(1)
        Arrays.sort(nums);
        int res = 0;
        for (int num: nums) {
            if (num > nums[res]) {
                res++;
            }
        }
        return res;
    }
}
