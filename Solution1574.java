// Leetcode 1574: Shortest Subarray to be Removed to Make Array Sorted
import java.util.*;

class Solution1574 {
    public int findLengthOfShortestSubarray(int[] arr) {
        // TC:O(N), SC:O(1)
        int left = 0;
        while (left+1 < arr.length && arr[left] <= arr[left+1])  left++;
        if (left == arr.length - 1) return 0;
        
        int right = arr.length - 1;
        while (right > left && arr[right-1] <= arr[right]) right--;
        int result = Math.min(arr.length-left-1, right);
        
        int i = 0, j = right;
        while (i <= left && j < arr.length) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
