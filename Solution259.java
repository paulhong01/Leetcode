// Leetcode 259: 3Sum Smaller
import java.util.*;

class Solution259 {
    public int threeSumSmaller(int[] nums, int target) {
        // TC:O(N^2), SC:O(1)
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length-2; i++) {
            int start = i+1;
            int end = nums.length-1;
            int sum = nums[i] + nums[start];
            // if (sum >= target)  break;
            while (start < end) {
                // System.out.printf("%d %d %d\n", start, end, sum);
                while (sum+nums[end] >= target && end > start) {
                    end--;
                }
                result += (end-start);
                sum -= nums[start++];
                sum += nums[start];
            }    
        }
        return result;
    }
}
