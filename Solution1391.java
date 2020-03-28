// Leetcode 1391: Check if There is a Valid Path in a Grid
import java.util.*;

class Solution1391 {
    public boolean hasValidPath(int[][] grid) {
        // BFS: TC:O(MN), SC:O(MN), where M = grid.length, N = grid[0].length
        int[][][] dirs = {
                {{0, -1}, {0, 1}},
                {{-1, 0}, {1, 0}},
                {{0, -1}, {1, 0}},
                {{0, 1}, {1, 0}},
                {{0, -1}, {-1, 0}},
                {{0, 1}, {-1, 0}}
        };
        
        int M = grid.length, N = grid[0].length;
        boolean[][] visited = new boolean[M][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == M - 1 && cur[1] == N - 1) {
                return true;
            }
            
            int[][] directions = dirs[grid[cur[0]][cur[1]]-1];
            for (int[] dir: directions) {
                int next_row = cur[0] + dir[0];
                int next_col = cur[1] + dir[1];
                
                if (next_row < M && next_row >= 0 && next_col < N && next_col >= 0 && !visited[next_row][next_col]) {
                    for (int[] back_dir: dirs[grid[next_row][next_col]-1]) {
                        if (next_row+back_dir[0] == cur[0] && next_col+back_dir[1] == cur[1]) {
                            visited[next_row][next_col] = true;
                            queue.add(new int[]{next_row, next_col});
                        }
                    }
                }
            }
        }
        
        return false;
        
    }
}