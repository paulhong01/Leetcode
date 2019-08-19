// Leetcode 126: Word Ladder II
import java.util.*;

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Method 1: BFS, TC:O(N), SC:O(N)
//         List<List<String>> result = new ArrayList();
//         Set<String> word_set = new HashSet(wordList);
//         if (!word_set.contains(endWord))    return result;

//         Queue<List<String>> queue = new LinkedList();
//         Queue<Set<String>> visited = new LinkedList();
//         List<String> start = new ArrayList();
//         start.add(beginWord);
//         Set<String> set = new HashSet();
//         set.add(beginWord);
//         boolean find_endWord = false;
//         queue.add(start);
//         visited.add(set);
//         while (!queue.isEmpty()) {
//             int size = queue.size();
//             for (int i = 0; i < size; i++) {
//                 List<String> cur = queue.poll();
//                 Set<String> cur_set = visited.poll();
//                 String last_word = cur.get(cur.size()-1);
//                 for (int s = 0; s < last_word.length(); s++) {
//                     for (char c = 'a'; c <= 'z'; c++) {
//                         if (c != last_word.charAt(s)) {
//                             String next_word = last_word.substring(0, s) + c + last_word.substring(s+1);
//                             if (next_word.equals(endWord)) {
//                                 cur.add(endWord);
//                                 result.add(cur);
//                                 find_endWord = true;
//                             } else if (word_set.contains(next_word) && !cur_set.contains(next_word)) {
//                                 List<String> next_list = new ArrayList(cur);
//                                 Set<String> next_set = new HashSet(cur_set);
//                                 next_list.add(next_word);
//                                 next_set.add(next_word);
//                                 queue.add(next_list);
//                                 visited.add(next_set);
//                             }
//                         }
//                     }
//                 }
//             }
//             if (find_endWord) {
//                 break;
//             }
//         }
//         return result;
       // Method 2 : DFS + BFS 
       HashSet<String> dict = new HashSet<String>(wordList);
       List<List<String>> res = new ArrayList<List<String>>();         
       HashMap<String, ArrayList<String>> nodeNeighbors = new HashMap<String, ArrayList<String>>();// Neighbors for every node
       HashMap<String, Integer> distance = new HashMap<String, Integer>();// Distance of every node from the start node
       ArrayList<String> solution = new ArrayList<String>();

       dict.add(beginWord);          
       bfs(beginWord, endWord, dict, nodeNeighbors, distance);                 
       dfs(beginWord, endWord, dict, nodeNeighbors, distance, solution, res);   
       return res;
    }
    
    // BFS: Trace every node's distance from the start node (level by level).
    private void bfs(String start, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance) {
    for (String str : dict)
        nodeNeighbors.put(str, new ArrayList<String>());

    Queue<String> queue = new LinkedList<String>();
    queue.offer(start);
    distance.put(start, 0);

    while (!queue.isEmpty()) {
        int count = queue.size();
        boolean foundEnd = false;
        for (int i = 0; i < count; i++) {
            String cur = queue.poll();
            int curDistance = distance.get(cur);                
            ArrayList<String> neighbors = getNeighbors(cur, dict);

            for (String neighbor : neighbors) {
                nodeNeighbors.get(cur).add(neighbor);
                if (!distance.containsKey(neighbor)) {// Check if visited
                    distance.put(neighbor, curDistance + 1);
                    if (end.equals(neighbor))// Found the shortest path
                        foundEnd = true;
                    else
                        queue.offer(neighbor);
                    }
                }
            }

            if (foundEnd)
                break;
        }
    }

    // Find all next level nodes.    
    private ArrayList<String> getNeighbors(String node, Set<String> dict) {
    ArrayList<String> res = new ArrayList<String>();
    char chs[] = node.toCharArray();

    for (char ch ='a'; ch <= 'z'; ch++) {
        for (int i = 0; i < chs.length; i++) {
            if (chs[i] == ch) continue;
            char old_ch = chs[i];
            chs[i] = ch;
            if (dict.contains(String.valueOf(chs))) {
                res.add(String.valueOf(chs));
            }
            chs[i] = old_ch;
        }

    }
    return res;
    }

    // DFS: output all paths with the shortest distance.
    private void dfs(String cur, String end, Set<String> dict, HashMap<String, ArrayList<String>> nodeNeighbors, HashMap<String, Integer> distance, ArrayList<String> solution, List<List<String>> res) {
        solution.add(cur);
        if (end.equals(cur)) {
        res.add(new ArrayList<String>(solution));
        } else {
        for (String next : nodeNeighbors.get(cur)) {            
                if (distance.get(next) == distance.get(cur) + 1) {
                    dfs(next, end, dict, nodeNeighbors, distance, solution, res);
                }
            }
        }           
    solution.remove(solution.size() - 1);
    }
}
