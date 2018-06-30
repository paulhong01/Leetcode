// Leetcode 167: Two Sum II - Input array is sorted
import java.util.*;

public class Solution167{
    public static void main(String args[]){
        int[] numbers = {2,7,11,15};
        int target = 9;
        Solution167 s = new Solution167();
        int[] result = s.twoSum(numbers, target);
        for(int i: result)  System.out.printf("%d ", i);
        System.out.println("");
    }

    public int[] twoSum(int[] numbers, int target) {
        // Use two pointers, TC: O(N), SC: O(1), where N = numbers.length
        int l = 0, r = numbers.length - 1;
        while (l < r){
            if (numbers[l] + numbers[r] == target){
                int[] result = {l+1, r+1};
                return result;
            }else if (numbers[l] + numbers[r] < target){
                l++;
            }else{
                r--;
            }
        }
        return null;
    }
}