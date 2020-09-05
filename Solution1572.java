// Leetcode 1572: Matrix Diagonal Sum

class Solution {
    public int diagonalSum(int[][] mat) {
        // TC:O(N), SC:O(1), where N = mat.length
        int size = mat.length;
        int ret = 0;
        for (int i = 0; i < size; i++) {
            ret += mat[i][i] + mat[i][size-i-1];
        }
        if (size % 2 == 1) {
            ret -= mat[size/2][size/2];
        }
        return ret;
    }
}