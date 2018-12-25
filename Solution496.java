// Leetcode 496: Next Greater Element I
import java.util.*;

class Solution496 {

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        Solution496 sol = new Solution496();
        int[] res = sol.nextGreaterElement(nums1, nums2);
        for (int r: res) System.out.printf("%d ", r);
        System.out.println("");
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // TC:O(n^2), SC:O(n)
//         Map<Integer, Integer> map = new HashMap();
//         for (int i = 0; i < nums2.length; i++) {
//             for (int j = i+1; j < nums2.length; j++) {
//                 if (nums2[j] > nums2[i]) {
//                     map.put(nums2[i], nums2[j]);
//                     break;
//                 }
//             }
//         }
        
//         for (int i = 0; i < nums1.length; i++) {
//             nums1[i] = map.getOrDefault(nums1[i], -1);
//         }
//         return nums1;
        
        // Method 2: Using stack to record 
        Map<Integer, Integer> map = new HashMap();
        Stack<Integer> stack = new Stack();
        for (int n: nums2) {
            while(!stack.isEmpty() && stack.peek() < n) {
                map.put(stack.pop(), n);
            }
            stack.push(n);
        }
        
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        return nums1;
    }
}