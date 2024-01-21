// Leetcode 2905: Find Indices With Index and Value Difference II

public class Solution2905 {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        // TC:O(N), SC:O(1)
        int min_index = 0, max_index = 0;
        for (int i = indexDifference; i < nums.length; i++) {
            if (nums[i-indexDifference] < nums[min_index]) {
                min_index = i - indexDifference;
            }
            if (nums[i-indexDifference] > nums[max_index]) {
                max_index = i - indexDifference;
            }
            if (nums[i] - nums[min_index] >= valueDifference) {
                return new int[]{min_index, i};
            }
            if (nums[max_index] - nums[i] >= valueDifference) {
                return new int[]{max_index, i};
            }
        }
        return new int[]{-1, -1};
    }
}
