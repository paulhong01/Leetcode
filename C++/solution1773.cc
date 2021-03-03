#include <iostream>
#include <vector>
#include <string>

namespace {
class Solution {
public:
    int countMatches(std::vector<std::vector<std::string>>& items, std::string ruleKey, std::string ruleValue) {
        // TC:O(N), SC:O(1), where N = items.size()
        int find_idx = 0;
        if (ruleKey == "type") {
            find_idx = 0;
        } else if (ruleKey == "color") {
            find_idx = 1;
        } else if (ruleKey == "name") {
            find_idx = 2;
        }
        
        int count = 0;
        for (const std::vector<std::string>& item : items) {
            if (item[find_idx] == ruleValue) {
                count++;
            }
        }
        return count;
    }
};
}