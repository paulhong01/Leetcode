// Leetcode 33: Search in Rotated Sorted Array
import java.util.*;

public class Solution33 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;

        Solution33 sol = new Solution33();
        int res = sol.search(nums, target);
        System.out.println(res);
    }

    public int search(int[] nums, int target) {
        // TC:O(log(n)), SC:O(1)
        if (nums.length == 0)   return -1;
        else if (nums.length == 1)  return (nums[0] == target)?0:-1;
        return pivotbinarysearch(nums, 0, nums.length - 1, target);
    }

    private int findpivot(int[] nums, int l, int r) {
        while (l <= r) {
            int m = (l + r)/2;
            // System.out.println(m);
            if (m != 0 && m != nums.length -1 && nums[m] < nums[m -1] && nums[m+1] > nums[m])    return m;
            else if (m == 0 && nums[m] < nums[m+1])  return m;
            else if (m == nums.length -1 && nums[m] < nums[m-1])    return m;
            else if (nums[m] >= nums[0]) l = m + 1;
            else r = m - 1;
        }
        return -1;
    }

    private int binarysearch(int[] nums, int l, int r, int target) {
        while (l <= r) {
            int m = (l + r)/2;
            if (nums[m] == target)  return m;
            else if (nums[m] < target)  l = m + 1;
            else r = m - 1;
        }
        return -1;
    } 

    private int pivotbinarysearch(int[] nums, int l, int r, int target) {
        if (l < r) {
            int pivot = (nums[l] > nums[r])?findpivot(nums, 0, nums.length-1):0;
            if (nums[pivot] == target) return pivot;
            else if (target >= nums[0] && pivot != 0)  return binarysearch(nums, 0, pivot-1, target);
            else if (pivot == 0)    return binarysearch(nums, l, r, target);
            else return binarysearch(nums, pivot+1, r, target);
        }
        return -1;
    }
}