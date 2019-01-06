class Solution300 {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        Solution300 sol = new Solution300();
        System.out.println(sol.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)   return 0;
                
        // Method 1: DP: O(n^2), One pass
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                    maxval = Math.max(maxval, dp[j]);
            }
            dp[i] = maxval + 1;
            result = Math.max(dp[i], result);
        }

        return result;
        
        // Method2: DP: O(nlog(n))
        // int len = nums.length;
        // int[] dp = new int[len+1];
        // int maxlen = 0;
        // dp[0] = nums[0];
        
        // for (int i = 1; i < len; i++) {
        //     if (nums[i] > nums[maxlen]) {
        //         dp[++maxlen] = nums[i];
        //     } else {
        //         int idx = binarySearch(dp, 0, maxlen, nums[i]);
        //         dp[idx] = nums[i];
        //     }
        // }
        // return maxlen+1;
        
    }
    
    private int binarySearch(int[] dp, int l, int h, int target) {
        while (l < h) {
            int m = l + (h - l)/2;
            if (dp[m] == target) {
                return m;
            } else if (dp[m] > target) {
                h -= 1;
            } else {
                l += 1;
            }
        }    
        return l;
    }
    
    
}