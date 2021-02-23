// Leetcode 1768: Merge Strings Alternately
#include <iostream>
#include <string>

class Solution {
public:
    std::string mergeAlternately(std::string word1, std::string word2) {
        std::string ret = "";
        int idx1 = 0, idx2 = 0;
        for (int idx1 = 0, idx2 = 0; idx1 < word1.size() || idx2 < word2.size();) {
            if (idx1 < word1.size()) {
                ret += word1[idx1];
                ++idx1;
            }
            if (idx2 < word2.size()) {
                ret += word2[idx2];
                ++idx2;
            }
        }
        return ret;
    }
};