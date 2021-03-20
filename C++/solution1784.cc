// Leetcode 1784: Check if Binary String Has at Most One Segment of Ones
#include <iostream>
#include <string>

namespace {
class Solution {
public:
    bool checkOnesSegment(std::string s) {
        return std::string::npos == s.find("01");
    }
};   
} // namespace
