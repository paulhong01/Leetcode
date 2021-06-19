// Leetcode 1898: Maximum Number of Removable Characters

class Solution1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        // TC:O(NlogM), SC:(M), N = removable.length, M = s.length()
        char[] letters = s.toCharArray();
        int l = 0, r = removable.length;
        while (l <= r) {
            int m = l + (r - l)/2;
            
            for (int i = 0; i < m; i++) {
                letters[removable[i]] = '/';
            }
            
            if (checkSubsequence(letters, p)) {
                l = m + 1;
            } else {
                for (int j = 0; j < m; ++j) {
                    letters[removable[j]] = s.charAt(removable[j]);
                }
                r = m - 1;
            }
        }
        return r;
    }
    
    private boolean checkSubsequence(char[] letters, String p) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < letters.length && idx2 < p.length()) {
            if (letters[idx1] != '/' && p.charAt(idx2) == letters[idx1]) idx2++;
            idx1++;
        }
        
        if (idx2 == p.length()) return true;
        return false;
    }
}