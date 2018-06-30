// Leetcode 566: Reshape the Matrix
import java.util.*;

public class Solution566{
    public static void main(String args[]){
        int[] nums = {{1, 2}, {3, 4}};
        int r = 1, c = 4;
    }

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        // TC:O(N), SC:O(1), where N = number of elements of nums       
        int o_r = nums.length;
        int o_c = nums[0].length;
        if (o_r*o_c != r*c)
            return nums;
        
        int[][] result = new int[r][c];
        for(int i = 0; i < r*c; i++){
            result[i/c][i%c] = nums[i/o_c][i%o_c];
        }
        return result;
        
    }

}