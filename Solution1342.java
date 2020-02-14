// Leetcode 1342: Number of Steps to Reduce a Number to Zero
import java.util.*;

class Solution1342 {
    public int numberOfSteps (int num) {
        // Method 1:
        // int ret = 0;
        // while (num > 0) {
        //     if (num % 2 != 0) {
        //         num -= 1;
        //         ret++;
        //     } else {
        //         num /= 2;
        //         ret++;
        //     }
        // }
        // return ret;
        
        // Method 2
        return Integer.bitCount(num) + (31 - Integer.numberOfLeadingZeros(num));
    }
}