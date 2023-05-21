// Leetcode 2658: Maximum Number of Fish in a Grid

class Solution2658 {
    // TC:O(N*M), SC:O(1), N = grid.length and M = grid[0].length
    int max_fish = 0;
    public int findMaxFish(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 0) {
                    max_fish = Math.max(max_fish, traversal(i, j, grid));
                }
            }
        }
        return max_fish;
    }

    private int traversal(int row, int col, int[][] grid) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        int total = grid[row][col];
        grid[row][col] = 0;
        total += traversal(row-1, col, grid);
        total += traversal(row, col-1, grid);
        total += traversal(row+1, col, grid);
        total += traversal(row, col+1, grid);
        return total;
    }
}
