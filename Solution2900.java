// Leetcode 2900: Longest Unequal Adjacent Groups Subsequence I

class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        // TC:O(N), SC:O(N)
        List<String> ret = new ArrayList<String>();
        int last = groups[0];
        ret.add(words[0]);
        for (int i = 1; i < n; i++) {
            if (last != groups[i]) {
                last = groups[i];
                ret.add(words[i]);
            }
        }
        return ret;
    }
}
