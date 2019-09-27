// Leetcode 34: Find First and Last Position of Element in Sorted Array
import java.util.*;

public class Solution34 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        Solution34 sol = new Solution34();
        int[] res = sol.searchRange(nums, target);
        for (int i = 0; i <= 1; i++) {
            System.out.printf("%d ", res[i]);
        }
        System.out.println();
    }

    private int binarysearch(int[] nums, int target, boolean left) {
        int l = 0, r = nums.length;

        while (l < r) {
            int m = l + (r - l)/2;
            if (nums[m] > target || (left && nums[m] == target)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public int[] searchRange(int[] nums, int target) {
        // int[] result = {-1, -1};

        // int leftidx = binarysearch(nums, target, true);

        // if (leftidx == nums.length || nums[leftidx] != target) {
        //     return result;
        // }

        // result[0] = leftidx;
        // result[1] = binarysearch(nums, target, false)-1;
        // return result;

        // Update version, TC:log(N), SC:O(1)
        int l = 0, r = nums.length-1;
        int left = -1, right = -1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] == target && (m == 0 || nums[m-1] != target)) {
                left = m;
                right = m;
                break;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        
        // Since we have already calculated the left part, we only need to check the right part
        r = nums.length - 1;
        while (l <= r) {
            int m = l + (r-l)/2;
            if (nums[m] == target && (m==nums.length-1 || nums[m+1] != target)) {
                right = m;
                break;
            } else if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        int[] ret = new int[] {left, right};
        return ret;
    }
}