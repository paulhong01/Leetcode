// Leetcode 269: Alien Dictionary
import java.util.*;

class Solution269 {
    public String alienOrder(String[] words) {
        // TC:(N), SC:O(N)
        Map<Character, Set<Character>> graph = new HashMap();
        int[] indegree = new int[26];
        buildGraph(words, graph, indegree);
        
        String ret = topologicalSort(graph, indegree);
        return ret.length()==graph.size()?ret:"";
    }
    
    private void buildGraph(String[] words, Map<Character, Set<Character>> graph, int[] indegree) {
        for (String word: words) {
            for (char c: word.toCharArray()) {
                graph.put(c, new HashSet());
            }
        }
        
        for (int i = 1; i < words.length; i++) {
            String first = words[i-1];
            String second = words[i];
            int len = Math.min(first.length(), second.length());
            
            for (int j = 0; j < len; j++) {
                char parent = first.charAt(j);
                char child = second.charAt(j);
                if (parent != child) {
                    if (!graph.get(parent).contains(child)) {
                        graph.get(parent).add(child);
                        indegree[child-'a']++;
                    }
                    break;
                }
            }
        }
    }
    
    private String topologicalSort(Map<Character, Set<Character>> graph, int[] indegree) {
        Queue<Character> queue = new LinkedList();
        for (char c: graph.keySet()) {
            if (indegree[c-'a'] == 0) {
                queue.add(c);
            }
        }
        
        StringBuilder ret = new StringBuilder();
        while (!queue.isEmpty()) {
            char cur = queue.poll();
            ret.append(cur);
            for (char neighbor : graph.get(cur)) {
                indegree[neighbor-'a']--;
                if (indegree[neighbor-'a'] == 0) {
                    queue.add(neighbor);
                }
            }
        }
        return ret.toString();
    }
}