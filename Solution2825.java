// Leetcode 2825: Make String a Subsequence Using Cyclic Increments

class Solution2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        // TC:O:(N), SC:O(1)
        int idx = 0;
        for (char c : str2.toCharArray()) {
            char alt = (c == 'a')?'z':(char)(c-1);
            while (idx < str1.length() && str1.charAt(idx) != c && str1.charAt(idx) != alt) {
                idx++;
            }
            if (idx >= str1.length()) {
                return false;
            }
            idx++;
        }
        return true;
    }
}
