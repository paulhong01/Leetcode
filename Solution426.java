// Leetcode 426: Convert Binary Search Tree to Sorted Doubly Linked List
import java.util.*;

class Solution426 {
    public Node treeToDoublyList(Node root) {
        // Method 1 : Extra list, TC:O(N), SC:O(N)
        // if (root == null)   return null;
        // List<Node> list = new ArrayList();
        // Stack<Node> stack = new Stack();
        // Node cur = root;
        // while (!stack.isEmpty() || cur != null) {
        //     while (cur != null) {
        //         stack.push(cur);
        //         cur = cur.left;
        //     }
        //     cur = stack.pop();
        //     list.add(cur);
        //     cur = cur.right;
        // }
        // for (int i = 1; i < list.size(); i++) {
        //     list.get(i-1).right = list.get(i);
        //     list.get(i).left = list.get(i-1);
        // }
        // list.get(0).left = list.get(list.size()-1);
        // list.get(list.size()-1).right = list.get(0);
        // return list.get(0);
        
        // TC:O(N), SC:O(N)
        if (root == null)   return null;
        Stack<Node> stack = new Stack();
        Node head = null;
        Node tail = null;
        Node prev = null;
        Node cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (prev == null) {
                prev = cur;
                head = cur;
            } else {
                prev.right = cur;
                cur.left = prev;
            }
            tail = cur;
            prev = cur;
            cur = cur.right;
        }
        tail.right = head;
        head.left = tail;
        return head;
    }
    
   
}