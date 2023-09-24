// Leetcode 2845: Count of Interesting Subarrays

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2845 {
    public long countInterestingSubarrays(List<Integer> nums, int mod, int k) {
        // TC:O(1), SC:O(1)
        long res = 0;
        int acc = 0;
        HashMap<Integer, Integer> map = new HashMap<>(Map.of(0, 1));
        for (int a : nums) {
            acc = (acc + (a % mod == k ? 1 : 0)) % mod;
            res += map.getOrDefault((acc - k + mod) % mod, 0);
            map.put(acc, map.getOrDefault(acc, 0) + 1);
        }
        return res;
    }
}
