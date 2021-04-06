// Leetcode 1816: Truncate Sentence
#include <iostream>
#include <string>

namespace {
class Solution {
public:
    std::string truncateSentence(std::string s, int k) {
        // TC:O(N), SC:O(1)
        std::stringstream ss(s);
        std::string ret = "";
        std::string word;
        int idx = 0;
        while (ss >> word) {
            if (idx == k) {
                break;
            } else if (idx == 0) {
                ret += word;
            } else {
                ret += " " + word;
            }
            idx++;
        }
        return ret;
    }
};
} // namespace