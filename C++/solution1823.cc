// Leetcode 1823: Find the Winner of the Circular Game
#include <iostream>
#include <vector>

namespace {
    class Solution1823 {
    public:
        int findTheWinner(int n, int k) {
            vector<int> list;
            for (int i = 1; i <= n; ++i) {
                list.push_back(i);
            }
            
            int idx = 0;
            while (list.size() >= 1) {
                idx = (idx + k - 1)%list.size();
                // cout << idx << endl;
                list.erase(list.begin() + idx);
            }
            return list[0];
        }
    };
} // namespace