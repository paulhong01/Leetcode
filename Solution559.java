// Leetcode 559: Maximum Depth of N-ary Tree
import java.util.*;

class Solution558 {
    public int maxDepth(Node root) {
        Queue<Node> queue = new LinkedList();
        if(root != null)    queue.add(root);
        int result = 0;
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                for (Node child: cur.children) {
                    if (child != null) queue.add(child);
                }
            }  
        }
        return result;
    }
} 