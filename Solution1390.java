// Leetcode 1390: Four Divisors
import java.util.*;

class Solution1390 {
    public int sumFourDivisors(int[] nums) {
        // TC:O(N^2), SC:O(N)
        int sum = 0;
        for (int n : nums) {
            int last_d = 0;
            for (int i = 2; i*i <= n; i++) {
                if (n % i == 0) {
                    if (last_d == 0) {
                        last_d = i;
                    } else {
                        last_d = 0;
                        break;
                    }
                }
            }
            
            if (last_d > 0 && last_d != n/last_d) {
                sum += 1 + n + last_d + n/last_d;
            }
        }
        return sum;
    }
}
