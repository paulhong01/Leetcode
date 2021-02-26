// Leetcode 1769: Minimum Number of Operations to Move All Balls to Each Box
import java.util.*;

class Solution1769 {
    public int[] minOperations(String boxes) {
        int[] ret = new int[boxes.length()];
        int count = 0, operations = 0;
        for (int i = 0; i < boxes.length(); i++) {
            ret[i] += operations;
            count += (boxes.charAt(i) == '1')?1:0;
            operations += count;
        }
        
        count = 0;
        operations = 0;
        for (int i = boxes.length()-1; i >= 0; i--) {
            ret[i] += operations;
            count += (boxes.charAt(i) == '1')?1:0;
            operations += count;
        }
        return ret;
    }
}