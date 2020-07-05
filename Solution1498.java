// Leetcode 1498: Number of Subsequences That Satisfy the Given Sum Condition
import java.util.*;

class Solution1498 {
    public int numSubseq(int[] nums, int target) {
        // TC:O(Nlog(N)), SC:O(N)
        Arrays.sort(nums);
        int res = 0, n = nums.length, l = 0, r = n - 1, mod = (int)1e9 + 7;
        int[] pows = new int[n];
        pows[0] = 1;
        for (int i = 1 ; i < n ; ++i)
            pows[i] = pows[i - 1] * 2 % mod;
        while (l <= r) {
            if (nums[l] + nums[r] > target) {
                r--;
            } else {
                res = (res + pows[r - l++]) % mod;
            }
        }
        return res;
    }
}