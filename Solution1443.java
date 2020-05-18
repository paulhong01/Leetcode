// Leetcode 1443: Minimum Time to Collect All Apples in a Tree
import java.util.*;

class Solution {
    private LinkedList<Integer>[] buildTree(int n, int[][] edges){
        LinkedList<Integer>[] adjList = new LinkedList[n];
        
        for(int i=0; i<n; ++i)
            adjList[i] = new LinkedList<>();
                
        for(int[] edge : edges)
            adjList[edge[0]].add(edge[1]);
        
        return adjList;
    }
    
    private int dfs(int root, LinkedList<Integer>[] adjList, List<Boolean> hasApple){
        int res = 0;
        for(int v : adjList[root])
            res += dfs(v, adjList, hasApple);
        
        // res = 0 means that the subtree rooted by root has no apples, so check root if it has an apple
        // otherwise, the subtree has one or more apples, thus, increment pass to root of tree.
        return (res > 0)? res + 1 : (hasApple.get(root))? 1 : 0;
    }
    
    // Time complexity O(N) and space complexity O(2N)
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        LinkedList<Integer>[] adjList = buildTree(n, edges);
        int res =  dfs(0, adjList, hasApple);
        
        return (res == 0)? 0 : (res - 1) * 2; // exclude root of the tree
    }
}