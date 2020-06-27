// Leetcode 1486: XOR Operation in an Array

class Solution1486 {
    public int xorOperation(int n, int start) {
        // TC:O(N), SC:O(1)
        int ret = 0;
        for (int i = 0; i < n; i++) {
            ret ^= (start + 2*i);
        }
        return ret;
    }
}