//Leetcode 442: Find All Duplicates in an Array
import java.util.*;

public class Solution442{
    public static void main(String[] args){
        int[] nums = {4,3,2,2,8,2,3,1};
        Solution442 s = new Solution442();
        List<Integer> result = s.findDuplicates(nums);
        for(int i: result){
            System.out.printf("%d ", i);
        }
        System.out.println("");
    }

    public List<Integer> findDuplicates(int[] nums) {
        // TC:O(N), SC:O(1)
        List<Integer> result = new ArrayList();
        for (int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] < 0){
                result.add(Math.abs(nums[i]));
            }
            nums[idx] = -nums[idx];
        }
        return result;
    }
}