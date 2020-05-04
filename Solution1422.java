// Leetcode 1422: Maximum Score After Splitting a String
import java.util.*;

class Solution1422 {
    public int maxScore(String s) {
        int len = s.length();
        int[] left_zero = new int[len];
        int[] right_one = new int[len];
        
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
            left_zero[i] = count;
        }
        
        int ret = 0;
        count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                ret = Math.max(ret, left_zero[i] + count);
                count++;
            } else if (i != len - 1) {
                ret = Math.max(ret, left_zero[i] + count);
            }
        }
        return ret;
    }
}