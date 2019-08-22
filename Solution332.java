// Leetcode 332: Reconstruct Itinerary
import java.util.*;

class Solution332 {
    List<String> result = new ArrayList();
    public List<String> findItinerary(List<List<String>> tickets) {
        // TC:O(N), SC:O(N)
        Map<String, PriorityQueue<String>> map = new HashMap();
        for (List<String> ticket : tickets) {
            if (!map.containsKey(ticket.get(0))) {
                map.put(ticket.get(0), new PriorityQueue());
            }
            map.get(ticket.get(0)).add(ticket.get(1));
        }
        dfs("JFK", map);
        return result;
    }
    
    private void dfs(String cur, Map<String, PriorityQueue<String>> map) {
        PriorityQueue<String> next_target = map.get(cur);
        while (next_target != null && !next_target.isEmpty()) {
            dfs(next_target.poll(), map);
        }
        result.add(0, cur);
    }
}