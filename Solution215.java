// Leetcode 215: Kth Largest Element in an Array
import java.util.*;

public class Solution215 {
    public static void main(String[] args) {
        // int[] nums = { 3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] nums = {3,2,1,5,6,4};
        // int k = 4;
        int k = 2;

        Solution215 sol = new Solution215();
        int res = sol.findKthLargest(nums, k);
        System.out.println(res);
    }

    public int findKthLargest(int[] nums, int k) {
        // Method 1: Use Java PriorityQueue
        PriorityQueue<Integer> pq = new PriorityQueue ();
        for (int n: nums) {
            pq.add(n);
        }

        int target = nums.length - k + 1;
        int cur = 0;
        for (int i = 0; i < target ; i++) {
            cur = pq.poll();
        }
        return cur;
    }
}