// Leetcode 2784: Check if Array is Good

class Solution {
    public boolean isGood(int[] nums) {
        // TC:O(N), SC:O(N)
        int N = nums.length-1;
        int[] count = new int[N];
        for (int num : nums) {
            if (num > N) {
                return false;
            }
            count[num-1]++;
        }

        for (int i = 0; i < N; i++) {
            if (i == N-1) {
                if (count[i] != 2) {
                    return false;
                }
            } else if (count[i] != 1) {
                return false;
            }
        }
        return true;
    }
}
