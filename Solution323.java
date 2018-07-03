// Leetcode 323: Number of Connected Components in an Undirected Graph
/* Description: Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes), write a function to find the number of connected components in an undirected graph.
   Example 1: 
   Input: n = 5 and edges = [[0, 1], [1, 2], [3, 4]]
     0          3
     |          |
     1 --- 2    4 
    Output: 2

    Example 2:
    Input: n = 5 and edges = [[0, 1], [1, 2], [2, 3], [3, 4]]

     0           4
     |           |
     1 --- 2 --- 3
    Output:  1
*/
import java.util.*;

public class Solution323{
    public static void main(String[] args){
        //int n = 5;
        //int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
        //int n = 5;
        //int[][] edges = {{0, 1}, {0, 2}, {2, 3},{2, 4}};
        int n = 4;
        int[][] edges = {{2, 3},{1, 2},{1, 3}};
        Solution323 s = new Solution323();
        int result = s.countComponents(n, edges);
        System.out.println(Integer.toString(result));
    }

    public int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        int[] rank = new int[n];
        for (int i = 0; i < n; i++){
            parent[i] = i;
        }
        for(int[] e: edges){
            int x = e[0], y = e[1];
            int rootx = find(x, parent), rooty = find(y, parent);
        
            if (rank[rootx] < rank[rooty]){
                parent[rootx] = rooty;
            } else{
                parent[rooty] = rootx;
                if (rank[rootx] == rank[rooty]){
                    rank[rootx]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++){
            result = parent[i] == i?result+1:result;
        }
        return result;
    }

    private int find(int idx, int[] parent){
        /*if (idx != parent[idx])
            return find(parent[idx], parent);*/
        while (idx != parent[idx]){
            parent[idx] = parent[parent[idx]];
            idx = parent[idx];
        }
        return idx;
    }
}