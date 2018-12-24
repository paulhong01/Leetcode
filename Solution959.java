// Leetcode 959: Regions Cut By Slashes

class Solution959 {
    int[] parent;
    int count, n;
    public int regionsBySlashes(String[] grid) {
        // We can treat this question as number of island
        // TC:O(n^3), SC:O(n^2)
        n = grid.length;
        count = 4*n*n;
        parent = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0)  union(g(i-1, j, 2), g(i, j, 0));
                if (j > 0)  union(g(i, j-1, 1), g(i, j, 3));
                if (grid[i].charAt(j) != '/') {
                    union(g(i, j, 0), g(i, j, 1));
                    union(g(i, j, 3), g(i, j, 2));
                }
                if (grid[i].charAt(j) != '\\') {
                    union(g(i, j, 0), g(i, j, 3));
                    union(g(i, j, 1), g(i, j, 2));
                }
            }
        }
        return count;
    }
    
    public int find(int idx) {
        if (parent[idx] != idx) return find(parent[idx]);
        return idx;
    }
    
    public void union(int idx1, int idx2) {
        int p1 = find(idx1), p2 = find(idx2);
        
        if (p1 != p2) {
            parent[p1] = p2;
            count--;
        }
    }
    
    public int g(int i, int j, int idx) {
        return (i*n + j)*4 + idx;
    }
}