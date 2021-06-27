// Leetcode 1905: Count Sub Islands
#include <iostream>
#include <vector>

namespace {
class Solution {
public:
    int countSubIslands(std::vector<std::vector<int>>& grid1, std::vector<std::vector<int>>& grid2) {
        int M = grid1.size(), N = grid1[0].size();
        int result = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (grid2[i][j] == 1) {
                    result += check(i, j, grid1, grid2);
                }
            }
        }
        return result;
    }
    
    int check(int row, int col, std::vector<std::vector<int>>& grid1, std::vector<std::vector<int>>& grid2) {
        int M = grid1.size(), N = grid1[0].size(), res = 1;
        if (row < 0 || row == M || col < 0 || col == N || grid2[row][col] == 0) return 1;
        grid2[row][col] = 0;
        res &= check(row-1, col, grid1, grid2);
        res &= check(row+1, col, grid1, grid2);
        res &= check(row, col-1, grid1, grid2);
        res &= check(row, col+1, grid1, grid2);
        return res & grid1[row][col];
    }
};    
} // namespace