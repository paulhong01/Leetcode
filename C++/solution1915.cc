// Leetcode 1915: Number of Wonderful Substrings
#include <iostream>
#include <map>
#include <string>

namespace {
class Solution {
public:
    long long wonderfulSubstrings(std::string word) {
        // TC:O(N), SC:O(N)
        std::unordered_map<int, int> count = {{0, 1}};
        int mask = 0; 
        long res = 0;
        for (char c : word) {
            mask ^= (1 << (c - 'a'));
            res += count[mask];
            for (int i = 0; i < 10; i++) {
                int lookfor = mask ^ (1 << i);
                res += count[lookfor];
            }
            ++count[mask];
        }
        return res;
    }
};    
}
