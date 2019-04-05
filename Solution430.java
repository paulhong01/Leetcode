// Leetcode 430: Flatten a Multilevel Doubly Linked List
import java.util.*;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};

class Solution {
    public Node flatten(Node head) {
        // TC:O(N), SC:O(1)
        Node cur = head;
        while (cur != null) {
            if (cur.child != null) {
                Node nextnode = flatten(cur.child);
                cur.child = null;
                Node originnext = cur.next;
                cur.next = nextnode;
                nextnode.prev = cur;
                while (cur.next != null) {
                    cur = cur.next;
                }
                cur.next = originnext;
                if (originnext!=null)   originnext.prev = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}