// Leetcode 1319: Number of Operations to Make Network Connected
import java.util.*;

class Solution1319 {
    public int makeConnected(int n, int[][] connections) {
        // Unioin find: TC:O(N+M), SC:O(N)
        if (connections.length < n - 1) return -1; // To connect all nodes need at least n-1 edges
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        int components = n;
        for (int[] connection : connections) {
            int p1 = findParent(parent, connection[0]);
            int p2 = findParent(parent, connection[1]);
            if (p1 != p2) {
                parent[p1] = p2; // Union 2 component
                components--;
            }
        }
        return components - 1; // Need (components-1) cables to connect components together
    }
    private int findParent(int[] parent, int i) {
        if (i == parent[i]) return i;
        return parent[i] = findParent(parent, parent[i]);
    }
}