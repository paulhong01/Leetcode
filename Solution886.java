// Leetcode 886: Possible Bipartition
import java.util.*;

class Solution886 {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] dislike: dislikes) {
            int start = Math.min(dislike[0], dislike[1]);
            int end = Math.max(dislike[0], dislike[1]);
            if (!map.containsKey(start)) {
                map.put(start, new LinkedList<>());
            }
            map.get(start).add(end);
        }
        
        boolean[] visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                int[] l = new int[N+1];
                int level = 1;
                
                while (!queue.isEmpty()) {
                    int size = queue.size();
                    for (int count = 0; count < size; count++) {
                        int cur = queue.poll();
                        if (l[cur] != 0 && l[cur] != level) {
                            return false;
                        }

                        if (visited[cur]) {
                            continue;
                        }
                        visited[cur] = true;
                        l[cur] = level;
                        for (int child: map.getOrDefault(cur, new ArrayList<>())) {
                            queue.add(child);
                        }
                    }
                    level = level == 1?2:1;
                }
            }
        }
        return true;
    }
}