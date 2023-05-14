// Leetcode 2616: Minimize the Maximum Difference of Pairs

class Solution2616 {
    public int minimizeMax(int[] nums, int p) {
        // TC:O(NlogN), SC:O(1)
        Arrays.sort(nums);
        int N = nums.length, left = 0, right = nums[N-1]-nums[0];
        while (left < right) {
            int mid = (left + right)/2;
            int k = 0;
            for (int i = 1; i < N && k < p; i++) {
                if (nums[i] - nums[i-1] <= mid) {
                    k++;
                    i++;
                }
            }

            if (k >= p) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
