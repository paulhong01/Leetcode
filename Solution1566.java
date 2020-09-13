// Leetcode 1566: Detect Pattern of Length M Repeated K or More Times
import java.util.*;

class Solution1566 {
    public boolean containsPattern(int[] arr, int m, int k) {
        // TC:O(N), SC:O(1)
        int count = 0;
        for (int i = 0; i < arr.length-m; i++) {
            if (arr[i] == arr[i+m]) {
                count++;
            } else {
                count = 0;
            }
            
            if (count == (k-1)*m) {
                return true;
            }
        }
        return false;
    }
}
