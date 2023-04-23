// Leetcode 2606: Find the Substring With Maximum Cost

class Solution2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        // TC:O(N+M), SC:O(M), where N = s.length() and M = chars.length()
        Map<Character, Integer> special_value = new HashMap<Character, Integer>();
        for (int i = 0; i < vals.length; i++) {
            special_value.put(chars.charAt(i), vals[i]);
        }

        int N = s.length();
        int max_cost = 0;
        int prefix_cost = 0;
        for (int i = 0; i < N; i++) {
            int cur_cost = (special_value.containsKey(s.charAt(i))?special_value.get(s.charAt(i)):s.charAt(i)-'a'+1);
            prefix_cost = Math.max(prefix_cost, 0) + cur_cost;
            max_cost = Math.max(max_cost, prefix_cost);
        }
        return max_cost;
    }
}