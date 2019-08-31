// Leetcode 317: Shortest Distance from All Buildings
import java.util.*;

class Solution317 {
    public int shortestDistance(int[][] grid) {
        // TC:O(N^2M^2), SC:O(NM), where N = grid.length, M = grid[0].length
        int N = grid.length, M = grid[0].length;
        int[][] dist = new int[N][M];
        int[][] reach = new int[N][M];
        int[] dir = new int[]{0, 1, 0, -1, 0};
        int total_building = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                boolean[][] visited = new boolean[N][M];
                Queue<int[]> queue = new LinkedList();
                
                if (grid[i][j] == 1) {
                    total_building++;
                    queue.add(new int[]{i, j});
                    int level = 1;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        for (int c = 0; c < size; c++) {
                            int[] cur = queue.poll();
                            for (int d = 1; d < dir.length; d++) {
                                int next_row = cur[0] + dir[d-1];
                                int next_col = cur[1] + dir[d];
                                if (next_row >= 0 && next_row < N && next_col >= 0 && next_col < M && grid[next_row][next_col] == 0 && !visited[next_row][next_col]) {
                                    dist[next_row][next_col] += level;
                                    reach[next_row][next_col] += 1;
                                    visited[next_row][next_col] = true;
                                    queue.add(new int[] {next_row, next_col});
                                }
                            }
                        }
                        level++;
                    }
                }
            }
        }
        
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (reach[i][j] == total_building) {
                    ret = Math.min(ret, dist[i][j]);
                }
            }
        }
        return ret == Integer.MAX_VALUE?-1:ret;
    }
}