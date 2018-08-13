// Leetcode 215: Kth Largest Element in an Array
import java.util.*;

public class Solution215 {
    public static void main(String[] args) {
        // int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] nums = {3,2,1,5,6,4};
        int k = 4;

        Solution215 sol = new Solution215();
        int res = sol.findKthLargest(nums, k);
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
        // Method 1: Use Java PriorityQueue, TC:O(n), SC:O(n)
        /* PriorityQueue<Integer> pq = new PriorityQueue ();
        for (int n: nums) {
            pq.add(n);
        }

        int target = nums.length - k + 1;
        int cur = 0;
        for (int i = 0; i < target ; i++) {
            cur = pq.poll();
        }
        return cur; */

        // Method 2: QuickSelect
        return quickSelect(nums, 0, nums.length - 1, nums.length - k + 1);
    }

    private int partition(int[] nums, int l, int r) {
        int i = l, pivot = nums[r];
        for (int idx = l; idx < r; idx++) {
            if (nums[idx] <= pivot) {
                // swap
                if (i != idx) {
                    int temp = nums[i];
                    nums[i] = nums[idx];
                    nums[idx] = temp;
                }
                i++;
            }
        }
        int temp = nums[r];
        nums[r] = nums[i];
        nums[i] = temp;

        return i;
    }

    private int quickSelect(int[] nums, int l, int r, int k) {
        // partition
        int pivotidx = partition(nums, l, r);
        if (pivotidx - l == k - 1) {
            return nums[pivotidx];
        } else if (pivotidx - l > k - 1) {
            return quickSelect(nums, l, pivotidx - 1, k);
        } else {
            return quickSelect(nums, pivotidx + 1, r, k - pivotidx + l - 1);
        }
    }
    
};