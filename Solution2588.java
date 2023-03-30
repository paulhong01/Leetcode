// Leetcode 2588:  Count the Number of Beautiful Subarrays

public class Solution2588 {
    public long beautifulSubarrays(int[] nums) {
        // TC:O(N), SC:O(N)
        Map<Integer, Integer> visited = new HashMap<Integer, Integer>();
        visited.put(0, 1);
        long result = 0; 
        int prefix = 0;
        for (int num : nums) {
            prefix ^= num;
            result += visited.getOrDefault(prefix, 0);
            visited.put(prefix, visited.getOrDefault(prefix, 0)+1);
        }
        return result;
    }
}
