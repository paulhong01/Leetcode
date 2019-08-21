// Leetcode 137: Single Number II
import java.util.*;

class Solution {
    public int singleNumber(int[] nums) {
        // Method 1: HashMap, TC:O(N), SC:O(N)
        // Map<Integer, Integer> map = new HashMap();
        // for (int n: nums) {
        //     map.put(n, map.getOrDefault(n, 0)+1);
        // }
        // for (int n: map.keySet()) {
        //     if (map.get(n) != 3) {
        //         return n;
        //     }
        // }
        // return -1;
        
        // Method 2: Bitwise, TC:O(N), SC:O(1)
        int SeenOnce = 0, SeenTwice = 0;
        for (int n : nums) {
            SeenOnce = ~SeenTwice&(SeenOnce^n);
            SeenTwice = ~SeenOnce&(SeenTwice^n);
        }
        return SeenOnce;
    }
}