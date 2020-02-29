// Leetcode 1362: Closest Divisors
import java.util.*;

class Solution1362 {
    public int[] closestDivisors(int num) {
        // TC:O(sqrt(num)), SC:O(1)
        for (int i = (int)Math.sqrt(num+2); i > 0; i--) {
            if ((num+1) % i == 0) {
                return new int[]{i, (num+1)/i};
            } else if ((num+2) % i == 0) {
                return new int[]{i, (num+2)/i};
            }
        }
        return new int[]{};
    }
}