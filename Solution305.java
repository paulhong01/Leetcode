// Leetcode 305: Number of Islands II
import java.util.*;

class Solution305 {
    class UnionFind {
        int[] parent;
        int[] rank;
        public UnionFind(int m, int n) {
            parent = new int[m*n];
            rank = new int[m*n];
            for (int i = 0; i < m*n; i++) {
                parent[i] = i;
            }
        }
        
        public int find(int idx) {
            int p = parent[idx];
            if (p != idx) {
                return find(p);
            }
            return p;
        }
        
        public void union(int idx1, int idx2) {
            int p1 = find(idx1), p2 = find(idx2);
            int r1 = rank[p1], r2 = rank[p2];
            if (r1 >= r2) {
                parent[p2] = p1;
            } else {
                parent[p1] = p2;
            }
        }
    }
    
    public int findResult(UnionFind un, int N, Set<Integer> set) {
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (un.find(i) == i && set.contains(i)) {
                result++;
            }
        }
        return result;
    }
    
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        UnionFind un = new UnionFind(m, n);
        Set<Integer> set = new HashSet();
        List<Integer> result = new ArrayList();
        for (int[] p : positions) {
            int idx = p[0]*n + p[1];
            set.add(idx);
            // Left
            int tempidx = p[0]*n + (p[1]-1);
            if (p[1] >= 1 && set.contains(tempidx)) {
                un.union(idx, tempidx);
            }
            // Up
            tempidx = (p[0]-1)*n + p[1];
            if (p[0] >= 1 && set.contains(tempidx)) {
                un.union(idx, tempidx);
            }
            // Down
            tempidx = (p[0]+1)*n + p[1];
            if (p[0] < m-1 && set.contains(tempidx)) {
                un.union(idx, tempidx);
            }
            // Right
            tempidx = p[0]*n + (p[1]+1);
            if (p[1] < n-1 && set.contains(tempidx)) {
                un.union(idx, tempidx);
            }
            result.add(findResult(un, m*n, set));
        }
        return result;
    }
}