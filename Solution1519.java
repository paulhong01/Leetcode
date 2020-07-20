// Leetcode 1519: Number of Nodes in the Sub-Tree With the Same Label
import java.util.*;

class Solution1519 {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        // DFS: TC:O(N), SC:O(N)
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] edge: edges) {
            if (!map.containsKey(edge[0])) {
                map.put(edge[0], new ArrayList<>());
            }
            map.get(edge[0]).add(edge[1]);
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], new ArrayList<>());
            }
            map.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int[] ret = new int[n];
        traversal(0, map, labels, visited, ret);
        return ret;
    }
    
    public int[] traversal(int cur, Map<Integer, List<Integer>> map, String labels, Set<Integer> visited, int[] ret) {
        int[] count = new int[26];
        if (!visited.contains(cur)) {
            visited.add(cur);
            List<Integer> child = map.getOrDefault(cur, new ArrayList<>());
            for (int c : child) {
                int[] child_count = traversal(c, map, labels, visited, ret);
                for (int i = 0; i < 26; i++) {
                    count[i] += child_count[i];
                }
            }
            count[labels.charAt(cur)-'a']++;
            ret[cur] = count[labels.charAt(cur)-'a'];
        }
        return count;
    }
}