// Leetcode 1528: Shuffle String
import java.util.*; 

class Solution1528 {
    public String restoreString(String s, int[] indices) {
        // TC:O(N), SC:O(N)
        char[] ret = s.toCharArray();
        for (int i = 0; i < indices.length; i++) {
            ret[indices[i]] = s.charAt(i);
        }
        return String.valueOf(ret);
    }
}