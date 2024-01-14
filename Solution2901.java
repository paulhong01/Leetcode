// Leetcode 2901: Longest Unequal Adjacent Groups Subsequence II

class Solution2910 {
    private boolean check(String[] words, int[] groups, int i, int j) {
        if (groups[i] == groups[j] || words[i].length() != words[j].length()) {
            return false;
        }

        int diff = 0;
        for (int w_idx = 0; w_idx < words[i].length(); ++w_idx) {
            if (words[i].charAt(w_idx) != words[j].charAt(w_idx)) {
                ++diff;
            }
        }
        return diff == 1;
    }

    private void solve(int n, String[] words, int[] groups, List<String> ret) {
        int[] len = new int[1001];
        int[] next = new int[1001];
        Arrays.fill(len, 1);
        Arrays.fill(next, -1);

        int start_idx = -1, max_len = 0;

        for (int i = n-1; i >= 0; --i) {
            for (int j = i + 1; j < n; ++j) {
                if (len[i] < len[j]+1 && check(words, groups, i, j)) {
                    len[i] = len[j] + 1;
                    next[i] = j;
                }
            }

            if (len[i] > max_len) {
                max_len = len[i];
                start_idx = i;
            }
        }

        while (start_idx != -1) {
            ret.add(words[start_idx]);
            start_idx = next[start_idx];
        }
    }

    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        // TC:O(N), SC:O(N)
        List<String> ret = new ArrayList<String>();
        solve(n, words, groups, ret);
        return ret;
    }
}