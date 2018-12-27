// Leetcode 503: Next Greater Element II
import java.util.*;

class Solution503 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Solution503 sol = new Solution503();
        int[] res = sol.nextGreaterElements(nums);
        for (int r: res) System.out.printf("%d ", r);
        System.out.println("");
    }

    public int[] nextGreaterElements(int[] nums) {
        // Method 1: Brute force  
        // TC:O(n^2), SC:O(n)
        // int[] result = new int[nums.length];
        // for (int i = 0; i < nums.length; i++) {
        //     result[i] = -1;
        //     for (int j = 1; j < nums.length; j++) {
        //         if (nums[(i+j)%nums.length] > nums[i]) {
        //             result[i] = nums[(i+j)%nums.length];
        //             break;
        //         }
        //     }
        // }
        // return result;

        // Method 2: Using stack
        // TC:O(n), SC:O(n)
        int[] result = new int[nums.length];
        Arrays.fill(result, -1);
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < 2*nums.length - 1; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % nums.length]) {
                int preidx = stack.pop();
                if (preidx >= nums.length)  continue;
                else    result[preidx] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return result;
    }
}