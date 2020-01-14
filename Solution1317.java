// Leetcode 1317: Convert Integer to the Sum of Two No-Zero Integers

class Solution {
    public int[] getNoZeroIntegers(int n) {
        // TC: O(N*M), SC:O(1)
        for (int i = 1; i < n; i++) {
            String first = String.valueOf(i);
            boolean zero = false;
            for (int idx = 0; idx < first.length(); idx++) {
                if (first.charAt(idx) == '0') {
                    zero = true;
                    break;
                }
            }
            if (zero)   continue;
            String second = String.valueOf(n-i);
            for (int idx = 0; idx < second.length(); idx++) {
                if (second.charAt(idx) == '0') {
                    zero = true;
                    break;
                }
            }
            if (zero)   continue;
            
            int[] ret = {i, n - i};
            return ret;
        }
        return null;
    }
}