//Leetcode 448: Find All Numbers Disappeared in an Array
import java.util.*;

public class Solution448{
    public static void main(String[] args){
        int[] nums = {4,3,2,7,8,2,3,1};
        Solution448 s = new Solution448();
        List<Integer> result = s.findDisappearedNumbers(nums);
        for (int i: result){
            System.out.printf("%d ", i);
        }
        System.out.println("");
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // TC:O(N), SC:O(1), where N = nums.length
        for (int i = 0; i < nums.length; i++){
            int idx = Math.abs(nums[i]) - 1;
            if (nums[idx] > 0){
                nums[idx] = -nums[idx];
            }
        }

        List<Integer> result = new ArrayList();
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                result.add(i+1);
            }
        }
        return result;
    }
}