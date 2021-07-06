// Leetcode 1920: Build Array from Permutation
import java.util.*;

class Solution {
    public int[] buildArray(int[] nums) {
        // TC:O(N), SC:O(N)
        int N = nums.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; ++i) {
            ans[i] = nums[nums[i]];
        }
        return ans;
    }
}
