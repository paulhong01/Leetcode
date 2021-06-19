// Leetcode 1899: Merge Triplets to Form Target Triplet
#include <iostream>
#include <vector>


namespace {
using namespace std;
class Solution {
public:
    bool mergeTriplets(vector<vector<int>>& triplets, vector<int>& target) {
        vector<int> res(3);
        for (const vector<int>& triplet : triplets) {
            if (triplet[0] <= target[0] && triplet[1] <= target[1] && triplet[2] <= target[2]) {
                res = {max(triplet[0], res[0]), max(triplet[1], res[1]), max(triplet[2], res[2])};
            }
        }
        return (res == target);
    }
};    

} // namespace