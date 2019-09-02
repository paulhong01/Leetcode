// Leetcode 708: Insert into a Cyclic Sorted List
import java.util.*;

class Solution708 {
    public Node insert(Node head, int insertVal) {
        // TC:O(N), SC:O(N)
        if (head == null) {
            head = new Node(insertVal, null);
            head.next = head;
            return head;
        }
        
        Node pre = head, cur = head.next;
        while (cur != head) {
            if (pre.val <= insertVal && cur.val >= insertVal)   break;
            if (pre.val > cur.val && (pre.val <= insertVal || cur.val >= insertVal))    break;
            pre = cur;
            cur = cur.next;
        }
        pre.next = new Node(insertVal, cur);
        return head;
    }
}