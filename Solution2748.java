// Leetcode 2748: Number of Beautiful Pairs

class Solution2748 {
    public int countBeautifulPairs(int[] nums) {
        // TC:O(NlogM), SC:O(1)
        int num_count[] = new int[10];
        Arrays.fill(num_count, 0);
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 1; j < 10; j++) {
                if (GetGcd(j, nums[i]%10) == 1) {
                    res += num_count[j];
                }
            }

            int cur_num = nums[i];
            while (cur_num >= 10) {
                cur_num /= 10;
            }
            num_count[cur_num]++;
        }
        return res;
    }

    private int GetGcd(int a, int b) {
        int small = a < b?a:b;

        for (int i = small; i > 0; i--) {
            if (a % i == 0 && b % i == 0) {
                return i;
            }
        }  
        return 1;
    }
}
