// Leetcode 1512: Number of Good Pairs
import java.util.*;

class Solution1512 {
    public int numIdenticalPairs(int[] nums) {
        // TC:O(N), SC:O(N)
        Map<Integer, Integer> map = new HashMap<>();
        int ret = 0;
        for (int n : nums) {
            if (map.containsKey(n)) {
                ret += map.get(n);
            }
            map.put(n, map.getOrDefault(n, 0)+1);
        }
        return ret;
    }
}