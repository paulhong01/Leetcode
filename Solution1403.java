// Leetcode 1403: Minimum Subsequence in Non-Increasing Order
import java.util.*;

class Solution1403 {
    public List<Integer> minSubsequence(int[] nums) {
        // TC:O(Nlog(N)), SC:O(1)
        int sum = 0;
        for (int n: nums) {
            sum += n;
        }
        
        List<Integer> ret = new ArrayList<>();
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length -1 ; i >= 0; i--) {
            count += nums[i];
            ret.add(nums[i]);
            if (count > sum-count) {
                break;
            }
        }
        return ret;
    }
}