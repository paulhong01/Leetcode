// Leetcode 2595: Number of Even and Odd Bits

public class Solution2595 {

public int[] evenOddBit(int n) {
    // TC:O(1), SC:O(1)
    int[] ret = new int[2];
    boolean even = true;
    while (n != 0) {
        if (even) {
            ret[0] += (n%2);
        } else {
            ret[1] += (n%2);
        }
        even = !even;
        n /= 2;
    }
    return ret;
}
    
}
