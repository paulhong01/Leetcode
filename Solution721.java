// Leetcode 721: Accounts Merge
import java.util.*;

class Solution721 {
    class DSU {
        int[] parent;
        public DSU() {
            parent = new int[10001];
            for (int i = 0; i < 10000; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int idx) {
            if (idx == parent[idx]) return idx;
            else return find(parent[idx]);
        }
        
        public void union(int idx1, int idx2) {
            int p1 = find(idx1), p2 = find(idx2);
            parent[p1] = p2;
        }
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> mailToName = new HashMap();
        Map<String, Integer> mailToId = new HashMap();
        int id = 0;
        for (List<String> account : accounts) {
            String name = "";
            for (String email: account) {
                if (name.equals("")) {
                    name = email;
                    continue;
                }
                
                mailToName.put(email, name);
                if (!mailToId.containsKey(email)) {
                    mailToId.put(email, id++);
                }
                dsu.union(mailToId.get(account.get(1)), mailToId.get(email));
            }
        }
        
        Map<Integer, List<String>> ans = new HashMap();
        for (String email: mailToName.keySet()) {
            int index = dsu.find(mailToId.get(email));
            ans.computeIfAbsent(index, x->new ArrayList()).add(email);
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, mailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }
}