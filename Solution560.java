// Leetcode 560: Subarray Sum Equals K
import java.util.*;

public class Solution560 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int k = 3;

        Solution560 sol = new Solution560();
        int res = sol.subarraySum(nums, k);
        System.out.println(res);
    }

    public int subarraySum(int[] nums, int k) {
        // Method 1: Brute Force, TC:O(n^2), SC:O(1)
        int result = 0;
        int count = 0;
        int size = nums.length;
        for (int start = 0; start < size; start++) {
            count = 0;
            for (int end = start; end < size; end++) {
                count += nums[end];
                if (count == k) {
                    result++;
                }
            }
        }
        return result;

        // Method 2: HashMap
        // HashMap<Integer, Integer> map = new HashMap();
        // map.put(0, 1);
        // int sum = 0, result = 0;
        // int size = nums.length;
        // for (int i = 0; i < size; i++) {
        //     sum += nums[i];
        //     int value = map.getOrDefault(sum - k, -1);
        //     if (value != -1) {
        //         result += value;
        //     }
        //     map.put(sum, map.getOrDefault(sum, 0) + 1);
        // }
        // return result;
    }
}