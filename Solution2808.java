// Leetcode 2808: Minimum Seconds to Equalize a Circular Array

class Solution2808 {
    public int minimumSeconds(List<Integer> nums) {
        // TC:O(N), SC:O(N)
        Map<Integer, List<Integer>> val_to_pos = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < nums.size(); i++) {
            if (!val_to_pos.containsKey(nums.get(i))) {
                val_to_pos.put(nums.get(i), new ArrayList<Integer>());
            }
            val_to_pos.get(nums.get(i)).add(i);
        }

        int ret = nums.size();
        for (List<Integer> pos : val_to_pos.values()) {
            pos.add(pos.get(0) + nums.size());
            int cur = 0;
            for (int i = 1; i < pos.size(); i++) {
                cur = Math.max(cur, (pos.get(i) - pos.get(i-1))/2);
            }
            ret = Math.min(ret, cur);
        }
        return ret;
    }
}