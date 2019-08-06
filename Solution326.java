// Leetcode 326: Power of Three
import java.util.*;

class Solution326 {
    public boolean isPowerOfThree(int n) {
        if (n == 0) return false;
        while (n > 1) {
            if (n%3 != 0)   return false;
            n /= 3;
        }
        return (n == 1);
    }
}