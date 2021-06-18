// Leetcode 1897: Redistribute Characters to Make All Strings Equal
#include <iostream>
#include <vector>
#include <string>

class Solution {
public:
    bool makeEqual(std::vector<std::string>& words) {
       std::vector<int> word_count(26, 0);
        for (const std::string& word : words) {
            for (int i = 0; i < word.length(); ++i) {
                ++word_count[word[i]-'a'];
            }
        }
        
        int N = words.size();
        for (int i = 0; i < 26; ++i) {
            if (word_count[i] % N != 0) {
                return false;
            }
        }
        return true;
    }
};