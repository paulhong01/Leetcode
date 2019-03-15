// Leetcode 990: Satisfiability of Equality Equations
import java.util.*;

class Solution990{
    public boolean equationsPossible(String[] equations) {
        // Union find: TC:O(N), SC:O(1)
        DSU dsu = new DSU();
        for (String eq: equations) {
            if (eq.substring(1, 3).equals("==")) {
                dsu.union(eq.charAt(0) -'a', eq.charAt(3)-'a');
            }
        }
        for (String eq: equations) {
            if (eq.charAt(1) == '!') {
                if (dsu.find(eq.charAt(0) - 'a') == dsu.find(eq.charAt(3)-'a')) return false;
            }
        }
        return true;
    }
    
}

class DSU {
    int[] parent;
    int[] rank;
    
    public DSU() {
        parent = new int[26];
        rank = new int[26];
        for (int i = 0; i < 26; i++)    parent[i] = i;
    }
    
    public int find(int idx) {
        if (idx != parent[idx]) return find(parent[idx]);
        return idx;
    }
    
    public void union(int idx1, int idx2) {
        int p1 = find(idx1), p2 = find(idx2);
        int r1 = rank[p1], r2 = rank[p2];
        
        if (r1 > r2) {
            parent[p2] = p1;
        } else if (r1 < r2) {
            parent[p1] = p2;
        } else {
            r1++;
            parent[p2] = p1;
        }
        return;
    }
}