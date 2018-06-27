// Leetcode 690: Employee Importance
import java.util.*;

class Solution690 {
    public int getImportance(List<Employee> employees, int id) {
        // Use BFS, TC:O(N), SC:O(E), where N = numbers of employees, E = numbers of subordinates
        HashMap<Integer, Employee> m = new HashMap();
        for (Employee e: employees){
            m.put(e.id, e);
        }
        
        Queue<Integer> q = new LinkedList();
        q.add(id);
        int result = 0;
        while (!q.isEmpty()){
            Employee cur = m.get(q.peek());
            result += cur.importance;
            for (Integer s: cur.subordinates){
                q.add(s);
            }
            q.remove();
        }
        return result;
    }
}