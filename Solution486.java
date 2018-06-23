import java.util.*;

class Solution486{
    /*
    public int helper(int[] nums, int s, int e){
        if (s == e)
            return nums[s];

        int a = nums[s] - helper(nums, s+1, e);
        int b = nums[e] - helper(nums, s, e-1);
        return Math.max(a, b);

    }
    */

    public boolean PredictTheWinner(int[] nums) {
        //return this.helper(nums, 0, nums.length-1)>=0;
        int dp[][] = new int[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++){
            dp[i][i] = nums[i];
        }

        for (int s = nums.length; s >= 0; s--){
            for (int e = s+1; e < nums.length; e++){
                int a = nums[s] - dp[s+1][e];
                int b = nums[e] - dp[s][e-1];
                dp[s][e] = Math.max(a, b);
            }
        }

        return dp[0][nums.length-1]>=0;
    }

    public static void main(String args[]){
        Solution486 s = new Solution486();
        int temp[] = {1, 5, 2};
        boolean result = s.PredictTheWinner(temp);
        if (result){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
