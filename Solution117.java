// Leetcode 117:  Populating Next Right Pointers in Each Node II
import java.util.*;

class Solution117 {
    public Node connect(Node root) {
        // Method 1: TC:O(N), SC:O(N)
        // Queue<Node> queue = new LinkedList();
        // if (root != null) {
        //     queue.add(root);
        //     root.next = null;
        // }   
        // while (!queue.isEmpty()) {
        //     int size = queue.size();
        //     for (int i = 0; i < size; i++) {
        //         Node cur = queue.poll();
        //         if (i != size-1) {
        //             cur.next = queue.peek();
        //         } else {
        //             cur.next = null;
        //         }
        //         if (cur.left != null)   queue.add(cur.left);
        //         if (cur.right != null)  queue.add(cur.right);
        //     }
        // }
        // return root;
        
        // Method 2: TC:O(n), SC:O(1)
        Node dummy = new Node(0);
        Node pre = dummy;
        Node cur = root;
        while (cur != null) {
            if (cur.left != null) {
                pre.next = cur.left;
                pre = pre.next;
            }
            if (cur.right != null) {
                pre.next = cur.right;
                pre = pre.next;
            }
            cur = cur.next;
            if (cur == null) {
                cur = dummy.next;
                pre = dummy;
                dummy.next = null;
            }
        }
        return root;
    }
}