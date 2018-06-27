//Leetcode 841: Keys and Rooms
import java.util.*;

class Solution841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Use BFS, TC:O(n), SC:O(n)
        int N = rooms.size();
        Queue<Integer> q = new LinkedList();
        HashSet<Integer> s = new HashSet();
        q.add(0);
        s.add(0);
        while (!q.isEmpty()){
            int pos = q.peek();
            int cur_size = rooms.get(pos).size();
            for (int i = 0; i < cur_size; i++){
                if (!s.contains(rooms.get(pos).get(i))){
                    q.add(rooms.get(pos).get(i));
                    s.add(rooms.get(pos).get(i));
                }
            }
            if (s.size() == N)
                return true;
            q.remove();
        }
        return false;
    }
}