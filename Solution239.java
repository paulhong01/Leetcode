// Leetcode 239: Sliding Window Maximum
import java.util.*;

class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Method 1: Brute foce, TC:O(NK), SC:O(1)
        // if (nums.length == 0)   return new int[k];
        // int N = nums.length;
        // int[] result = new int[N-k+1];
        // for (int i = 0; i <= N-k; i++) {
        //     int cur_max = nums[i];
        //     for (int j = 0; j < k; j++) {
        //         cur_max = Math.max(cur_max, nums[i+j]);
        //     }
        //     result[i] = cur_max;
        // }
        // return result;

        // Method 2: Deque, TC:O(N), SC:O(N)
        int N = nums.length;
        if (N == 0) return new int[k];
        int[] result = new int[N-k+1];
        Deque<Integer> dequeue = new LinkedList();
        for (int i = 0; i < N; i++) {
            while (dequeue.size() > 0 && nums[i] >= nums[dequeue.getLast()]) {
                dequeue.removeLast();
            }
            dequeue.addLast(i);
            if (i-k+1 >= 0) result[i-k+1] = nums[dequeue.getFirst()];
            if (i-k+1 >= dequeue.getFirst()) dequeue.removeFirst();
        }
        return result;
    }
}