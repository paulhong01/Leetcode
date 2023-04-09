// Leetcode 2596: Check Knight Tour Configuration

class Solution2596 {
    public boolean checkValidGrid(int[][] grid) {
        // TC:O(N), SC:O(N), where N = grid.length * grid.length
        if (grid[0][0] != 0) {
            return false;
        }
        int N = grid.length;
        int[][] positions = new int[N*N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int idx = grid[i][j];
                positions[idx][0] = i;
                positions[idx][1] = j;
            }
        }

        for (int i = 1;i < N*N; i++) {
            if (!ValidPosition(positions[i-1], positions[i])) {
                return false;
            }
        }
        return true;
    }

    private boolean ValidPosition(int[] prev_pos, int[] cur_pos) {
        return (Math.abs(cur_pos[0] - prev_pos[0]) == 2 && Math.abs(cur_pos[1] - prev_pos[1]) == 1) ||
               (Math.abs(cur_pos[0] - prev_pos[0]) == 1 && Math.abs(cur_pos[1] - prev_pos[1]) == 2);
    }
}