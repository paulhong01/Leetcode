//Leetcode 561: Array Partition I
import java.util.*;

public class Solution561{
    public static void main(String args[]){
        int[] nums = {1,4,3,2};
        Solution561 s = new Solution561();
        int result = s.arrayPairSum(nums);
        System.out.printf("%d\n", result);
    }

    public int arrayPairSum(int[] nums) {
        // TC:O(nlog(n)), since java built-in sort function has O(nlog(n)), SC:O(1)
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length; i += 2){
            result += nums[i];
        }
        return result;
    }
}