// Leetcode 1822: Sign of the Product of an Array
import java.util.*;

class Solution1822 {
    public int arraySign(int[] nums) {
        // TC:O(N), SC:O(1)
        int sign = 1;
        for (int num : nums) {
            if (num == 0) {
                return 0;
            } else if (num < 0) {
                sign *= -1;
            }
        }
        return sign;
    }
}