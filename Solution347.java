// Leetcode 347: Top K Frequent Elements
import java.util.*;

public class Solution347 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        // int[] nums = {1};
        int k = 2;
        // int k = 1;

        Solution347 sol = new Solution347();
        List<Integer> res = sol.topKFrequent(nums, k);
        System.out.println(res);
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        // TC:O(n), SC:O(n)
        // Map
        Map<Integer, Integer> map = new HashMap();
        for (int key: nums) {
            int value = map.getOrDefault(key, 0);
            map.put(key, value+1);
        }

        // Bucket
        List<Integer>[] bucket = new List[nums.length];
        for (int key: map.keySet()) {
            int value = map.get(key);
            if (bucket[value-1] == null) {
                bucket[value-1] = new ArrayList<Integer> ();
            }
            bucket[value-1].add(key);
        }

        // Find result by order
        List<Integer> result = new ArrayList();
        for (int i = nums.length-1; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result;
    }
}