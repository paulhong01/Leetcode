// Leetcode 16: 3Sum Closest
import java.util.*;

public class Solution16 {
    public static void main(String[] args) {
        int[] nums = {1, 1, -1, -1 ,3};
        int target = -1;
        
        Solution16 sol = new Solution16();
        int res = sol.threeSumClosest(nums, target);
        System.out.println(res);
    }

    public int threeSumClosest(int[] nums, int target) {
        // TC:O(n^2), SC:O(1)
        Arrays.sort(nums);
        int tempresult = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int curval = nums[i];
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int cursum = curval + nums[l] + nums[r];
                if (Math.abs(cursum - target) < Math.abs(tempresult - target)) {
                    tempresult = cursum;
                    System.out.println(tempresult);
                }
                if (cursum == target) return tempresult;
                if (cursum < target)    l++;
                else r--;
            }
        }
        return tempresult;
    }
}