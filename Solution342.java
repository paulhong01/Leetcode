// Leetcode 342: Power of Four
import java.util.*;

class Solution342 {
    public boolean isPowerOfFour(int num) {
        // TC:O(1), SC:O(1)
        return num > 0 && (num&(num-1)) == 0 && (num & 0x55555555) != 0;
    }
}