// Leetcode 1769: Minimum Number of Operations to Move All Balls to Each Box
#include <iostream>
#include <vector>
#include <string>

namespace {
class Solution {
public:
    std::vector<int> minOperations(std::string boxes) {
        std::vector<int> ret(boxes.length(), 0);
        int count = 0, operations = 0;
        for (int i = 0; i < boxes.length(); i++) {
            ret[i] += operations;
            count += (boxes[i] == '1')?1:0;
            operations += count;
        }
        
        count = 0;
        operations = 0;
        for (int i = boxes.length()-1; i >= 0; i--) {
            ret[i] += operations;
            count += (boxes[i] == '1')?1:0;
            operations += count;
        }
        return ret;
    }
};
} // namespace