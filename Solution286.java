//Leetcode 286: Walls and Gates
/* 
  Description: You are given a m x n 2D grid initialized with these three possible values.
  1.  -1 - A wall or an obstacle.
  2.  0 - A gate.
  3.  INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
  Fill each empty room with the distance to its nearest gate. If it is impossible to reach a gate, it should be filled with INF.

  Example:
  Given the 2D grid:
    INF  -1  0  INF
    INF INF INF  -1
    INF  -1 INF  -1
    0  -1   INF INF
  After running your function, the 2D grid should be:
    3  -1   0   1
    2   2   1  -1
    1  -1   2  -1
    0  -1   3   4

*/
import java.util.*;

public class Solution286{
    private static int INF = 2147483647;
    public static void main(String[] args){
        int[][] rooms = {{INF, -1, 0, INF}, {0, INF, INF, -1}, {INF, -1, INF, -1}, {0, -1, INF, INF}};
        Solution286 s = new Solution286();
        s.wallsAndGates(rooms);
        for (int[] row: rooms){
            for (int i: row){
                System.out.printf("%d ", i);
            }
            System.out.println("");
        }

    }

    public void wallsAndGates(int[][] rooms) {
        // Method1 : DFS, while countering 0, go through the node
        // TC: O(kmn), SC:O(kmn), where k = number of gates, m = rooms.length, n = rooms[0].length
        // Time Complexity too high
        /*
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[i].length; j++){
                if (rooms[i][j] == 0){
                    helper(rooms, i, j, 0);
                }
            }
        }
        */

        // Method 2 : BFS, put the elements to the queue from the shortest distance
        // TC:O(mn), SC:O(mn)
        Queue<int[]> q = new LinkedList();
        int[][] distance = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // Put gate to queue
        for (int i = 0; i < rooms.length; i++){
            for (int j = 0; j < rooms[i].length; j++){
                if (rooms[i][j] == 0)
                    q.add(new int[]{i, j});
            }
        }

        while (!q.isEmpty()){
            int[] cur = q.poll();
            int row = cur[0], col = cur[1];
            int next_row, next_col;
            for(int[] d: distance){
                next_row = row + d[0];
                next_col = col + d[1];
                if (next_row < 0 || next_row >= rooms.length || next_col < 0 || next_col >= rooms[0].length || rooms[next_row][next_col] != INF){
                    continue;
                }
                rooms[next_row][next_col] = rooms[row][col] + 1;
                q.add(new int[]{next_row, next_col});
            }
        }
    }

    // DFS traversal
    private void helper(int[][] rooms, int row, int col, int distance){
        // Check boundary condition and get in condition
        //System.out.printf("Row: %d, Col: %d, Dist: %d\n", row, col, distance);
        if (row < 0 || row >= rooms.length || col < 0 || col >= rooms[0].length || rooms[row][col] == -1 || rooms[row][col] < distance){
            return;
        } 

        rooms[row][col] = distance;
        helper(rooms, row+1, col, distance+1);
        helper(rooms, row-1, col, distance+1);
        helper(rooms, row, col+1, distance+1);
        helper(rooms, row, col-1, distance+1);
    }

}
