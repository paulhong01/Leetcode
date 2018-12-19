// Leetcode 684: Redundant Connection

class Solution684 {
    int MAX_EDGE_VAL = 1000;
    
    public int[] findRedundantConnection(int[][] edges) {
        // Method 1: DFS
//         List<Integer>[] graph = new ArrayList[MAX_EDGE_VAL+1];
//         for (int i = 0; i <= MAX_EDGE_VAL; i++) {
//             graph[i] = new ArrayList();
//         }
        
//         Set<Integer> visited = new HashSet();
//         for (int[] e: edges) {
//             visited.clear();
//             if (!graph[e[0]].isEmpty() && !graph[e[1]].isEmpty() && dfs(graph, e[0], e[1], visited)) {
//                 return e;
//             }
//             graph[e[0]].add(e[1]);
//             graph[e[1]].add(e[0]);
//         }
//         return null;
        
        // Method 2: Union find
        DSU dsu = new DSU(MAX_EDGE_VAL);
        for (int[] e: edges) {
            if (!dsu.union(e[0], e[1])) {
                return e;
            }
        }
        return null;
    }
    
    private boolean dfs(List<Integer>[] graph, int source, int target, Set<Integer> visited) {
        if (!visited.contains(source)) {
            visited.add(source);
            if (source == target)   return true;
            for (int newsource: graph[source])  {
                if (dfs(graph, newsource, target, visited)) return true;
            }
        }
        return false;
    }
}

class DSU {
    int[] parent;
    int[] rank;
    
    public DSU(int MAX_EDGE_VAL) {
        parent = new int[MAX_EDGE_VAL+1];
        for (int i = 0; i <= MAX_EDGE_VAL; i++) parent[i] = i;
        rank = new int[MAX_EDGE_VAL+1];
    }
    
    public int find(int in) {
        if (in != parent[in])
            return find(parent[in]);
        return in;
    }
    
    public boolean union(int x, int y) {
        int px = find(x);
        int py = find(y);
        int rx = rank[px];
        int ry = rank[py];
        // System.out.printf("%d %d %d %d\n", x, px, y, py)
        if (px == py) {
            return false;
        } else if (rx < ry) {
            parent[px] = py;
        } else if (rx > ry) {
            parent[py] = px;
        } else {
            parent[py] = px;
            rank[px]++;
        }
        return true;
    }
}