// Leetcode 547: Friend Circles
import java.util.*;

class Solution547 {
    public int findCircleNum(int[][] M) {
        // Use BFS, TC: O(N^2) SC:O(N) 
        Boolean []visited = new Boolean[M.length];
        Queue<Integer> q = new LinkedList();
        Arrays.fill(visited, false);
        int result = M.length;
        for (int i = 0; i < M.length; i++){
            if (!visited[i]){
                visited[i] = true;
                q.add(i);
                while (!q.isEmpty()){
                    int cur = q.peek();
                    for (int j = 0; j < M.length; j++){
                        if (M[cur][j] == 1 && !visited[j]){
                            visited[j] = true;
                            result--;
                            q.add(j);
                        }
                    }
                    q.remove();
                }
            }
        }
        return result;
    }
}