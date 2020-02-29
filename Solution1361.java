// Leetcode 1361: Validate Binary Tree Nodes
import java.util.*;

class Solution1361 {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        // Using indegree to check, TC:O(n), SC:(n)
        int[] indegree = new int[n];
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.add(i);
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    if (indegree[cur] > 1) {
                        return false;
                    }
                    if (leftChild[cur] != -1) {
                        queue.add(leftChild[cur]);
                        indegree[leftChild[cur]]++;
                    }
                    if (rightChild[cur] != -1) {
                        queue.add(rightChild[cur]);
                        indegree[rightChild[cur]]++;
                    }
                }
            }
        }
        
        int num_root = 0;
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                num_root++;
            }
        }
        return true&&(num_root==1);
    }
}