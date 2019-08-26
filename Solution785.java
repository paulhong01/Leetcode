// Leetcode 785: Is Graph Bipartite?
import java.util.*;

class Solution785 {
    public boolean isBipartite(int[][] graph) {
        // TC:O(N), SC:O(N)
        int N = graph.length;
        int[] layer = new int[N];
        Arrays.fill(layer, -1);
        
        Queue<Integer> queue = new LinkedList();
        int level = 0;
        for (int idx = 0; idx < N; idx++) {
            if (layer[idx] == -1 && graph[idx].length >= 1) {
                queue.add(idx);
                
                while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                        int cur = queue.poll();
                        layer[cur] = level;
                        for (int next_target : graph[cur]) {
                            if (layer[next_target] == level) {
                                return false;
                            } else if (layer[next_target] == -1) {
                                queue.add(next_target);
                            }
                        }
                    }
                    level ^= 1;
                }               
            }     
        }   
        return true;
    }
}