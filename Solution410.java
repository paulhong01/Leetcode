// Leetcode 410: Split Array Largest Sum
import java.util.*;

class Solution410 {
    public int splitArray(int[] nums, int m) {
        long l = nums[0];
        long r = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (l < nums[i])    l = nums[i];
            r += nums[i];
        }
        
        long result = r;
        while (l <= r) {
            // System.out.printf("%d %d\n", l, r);
            long mid = l + (r - l)/2;
            int count = 1;
            long sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (sum + nums[i] > mid) {
                    count++;
                    sum = nums[i];
                } else {
                    sum += nums[i];
                }
            }
            
            if (count <= m) {
                result = Math.min(result, mid);
                r = mid-1;
            } else {
                l = mid + 1;
            }
        }
        return (int)result;
    }
}