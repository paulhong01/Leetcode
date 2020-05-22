// Leetcode 1452: 

class Solution {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        // TC:O(NlogN), SC:O(N)
        List<Set<String>> elements = new ArrayList<>();
        for (List<String> elm: favoriteCompanies) {
            elements.add(new HashSet<>(elm));
        }
        int N = favoriteCompanies.size();
        int[] parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                int root1 = find(parent, i), root2= find(parent, j);
                if (root1 == root2) continue;
                else if (contains(elements.get(root1), elements.get(root2))) {
                    parent[root2] = root1;
                } else if (contains(elements.get(root2), elements.get(root1))) {
                    parent[root1] = root2;
                }
            }
        }
        
        Set<Integer> re_set = new HashSet<>();
        for (int p: parent) {
            re_set.add(find(parent, p));
        }
        List<Integer> ret = new ArrayList<>();
        ret.addAll(re_set);
        Collections.sort(ret);
        return ret;
    }
    
    public boolean contains(Set<String> set1, Set<String> set2) {
        if (set1.size() <= set2.size()) {
            return false;
        }
        return set1.containsAll(set2);
    }
    
    public int find(int[] parent, int idx) {
        if (parent[idx] == idx) {
            return idx;
        }
        return find(parent, parent[idx]);
    }
}