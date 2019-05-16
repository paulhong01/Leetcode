// Leetcode 133: Clone Graph
import java.util.*;

class Solution133 {
    public Node cloneGraph(Node node) {
        // BFS: TC:O(N), SC:O(N)
        Map<Integer, Node> map = new HashMap();
        map.put(node.val, new Node(node.val, new ArrayList()));
        Queue<Node> queue = new LinkedList();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            Node cur = map.get(temp.val);
            for (Node n: temp.neighbors) {
                if (map.containsKey(n.val)) {
                    // System.out.printf("in map %d:\n", n.val);
                    cur.neighbors.add(map.get(n.val));
                } else {
                    // System.out.println(n.val);
                    map.put(n.val, new Node(n.val, new ArrayList()));
                    cur.neighbors.add(map.get(n.val));
                    queue.add(n);
                }
            }
        }
        return map.get(node.val);
    }
}