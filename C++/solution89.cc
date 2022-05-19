// Leetcode 89: Gray Code
#include <vector>

namespace {
class Solution89 {
public:
    std::vector<int> grayCode(int n) {
        // TC:O(2^N), SC:O(1)
        std::vector<int> ret;
        ret.push_back(0);
        if (n == 0) {
            return ret;
        }
        ret.push_back(1);
        int pow = 1;
        for (int i = 1; i < n; i++) {
            pow <<= 1;
            int cur_size = ret.size();
            for (int j = cur_size - 1; j >= 0; --j) {
                ret.push_back(ret[j]+pow);
            }
        }
        return ret;
    }
};
}   // namespace
