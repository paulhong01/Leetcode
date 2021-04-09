// Leetcode 1817. Finding the Users Active Minutes
#include <iostream>
#include <vector>

class Solution {
public:
    std::vector<int> findingUsersActiveMinutes(std::vectorstd::<vector<int>>& logs, int k) {
        unordered_map<int, unordered_set<int>> m;
        for (const vector<int>& log: logs) {
            m[log[0]].insert(log[1]);
        }
        vector<int> ret(k);
        for (auto [key, value]: m) {
            int size = value.size() - 1;
            if (size < k) {
                ret[size]++;
            }
        }
        return ret;
    }
};