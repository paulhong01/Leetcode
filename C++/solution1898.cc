// Leetcode 1898: Maximum Number of Removable Characters
#include <iostream>
#include <string>

namespace {
class Solution {
public:
    int maximumRemovals(string s, string p, vector<int>& removable) {
        string letters = s;
        int l = 0, r = removable.size();
        while (l <= r) {
            int m = l + (r - l)/2;
            
            for (int i = 0; i < m; i++) {
                letters[removable[i]]='/';
            }
                        
            if (checkSubsequence(letters, p)) {
                l = m + 1;
            } else {
                for (int j = 0; j < m; j++) {
                    letters[removable[j]] = s[removable[j]];
                }
                r = m - 1;
            }
        }
        return r;
    }
                        
    bool checkSubsequence(string letter, string p) {
        int idx1 = 0, idx2 = 0;
        while (idx1 < letter.length() && idx2 < p.length()) {
            if (letter[idx1] != '/' && letter[idx1] == p[idx2]) idx2++;
            idx1++;
        }
        if (idx2 == p.length()) return true;
        return false;
    }
};    
} // namespace
