// Leetcode 1394: Find Lucky Integer in an Array
import java.util.*;

class Solution1394 {
    public int findLucky(int[] arr) {
        // Search Frequency: TC:O(N), SC:O(N)
        int LEN = 501;
        int[] freq = new int[LEN];
        Arrays.fill(freq, -1);
        
        for (int n : arr) {
            if (freq[n] == -1) {
                freq[n] = 1;
            } else {
                freq[n]++;
            }
        }
        
        for (int i = LEN-1; i >= 0; i--) {
            if (freq[i] == i) {
                return i;
            }
        }
        return -1;
    }
}