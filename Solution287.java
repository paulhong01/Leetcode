// Leetcode 287 Find the Duplicate Number
import java.util.*;

class Solution287{
    public static void main(String args[]){
        int nums[] = {2, 1, 3, 2, 4};
        //nt nums[] = {2, 2, 2, 2, 2};
        Solution287 s = new Solution287();
        int result = s.findDuplicate(nums);
        System.out.printf("%d\n", result);
    }

    public int findDuplicate(int[] nums) {
        // Method 1: PriorityQueue TC:O(n) SC:O(n)
        /*
        PriorityQueue<Integer> pq = new PriorityQueue();
        for (int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }

        while (pq.size() != 0){
            int temp = pq.poll();
            if (temp == pq.peek())  return temp;
        }
        */

        // Method 2: Modify the array, TC: O(n), SC:O(1)
        /*
        for (int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0){
                nums[idx] = -nums[idx];
            }else{
                return nums[i];
            }
        }
        return -1;
        */

        // Method 3: Binary Search TC: O(nlog(n)) SC:O(1)
        /*
        int size = nums.length;
        int l = 1, h = size - 1;
        while (l < h){
            int m = l + (h - l)/2;
            int count = 0;
            for (int num: nums){
                if (num <= m)   count++;
            }
            if (count <= m) l = m + 1;
            else    h = m;
        }
        return l;
        */

        // Method 4: Using linked list and loop TC:O(n) SC:O(1)
        int slow = nums[0];
        int fast = nums[nums[0]];
        while (slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    } 
}