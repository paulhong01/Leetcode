// Leetcode 88: Merge Sorted Array
#include <vector>

namespace {
class Solution88 {
public:
    void merge(std::vector<int>& nums1, int m, std::vector<int>& nums2, int n) {
        // TC:O(N), SC:O(1)
        int idx1 = m - 1, idx2 = n - 1;
        for (int i = nums1.size() - 1; i >= 0; i--) {
            if (idx2 < 0) {
                break;
            } else if (idx1 < 0) {
                nums1[i] = nums2[idx2];
                --idx2;
            } else if (nums1[idx1] > nums2[idx2]) {
                nums1[i] = nums1[idx1];
                --idx1;
            } else {
                nums1[i] = nums2[idx2];
                --idx2;
            }
        }
        return;
    }
};    
}   // namespace
