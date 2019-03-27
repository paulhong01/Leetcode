// Leetcode 116: Populating Next Right Pointers in Each Node
import java.util.*;

class Solution116 {
    public Node connect(Node root) {
        // TC:O(N), SC:O(N)
        // Queue<Node> queue = new LinkedList();
        // if (root != null) {
        //     queue.add(root);
        //     root.next = null;
        // } 
        // while (!queue.isEmpty()) {
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         Node cur = queue.poll();
        //         if (i == size-1) {
        //             cur.next = null;
        //         } else {
        //             cur.next = queue.peek();
        //         }
        //         if (cur.left != null)   queue.add(cur.left);
        //         if (cur.right != null)  queue.add(cur.right);
        //     }
        // }
        // return root;
        
        // Method 2: TC:O(n), SC:O(1)
        Node cur = root;
        while (cur != null) {
            Node level = cur;
            while (level != null) {
                if (level.left != null) level.left.next = level.right;
                if (level.right != null && level.next != null)    level.right.next = level.next.left;
                level = level.next;
            }
            cur = cur.left;
        }
        return root;
    }
}