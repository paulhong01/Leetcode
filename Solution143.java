// Leetcode 143: Reorder List
import java.util.*;

class Solution143 {
    public void reorderList(ListNode head) {
        // Method 1: TC:O(N), SC:O(N)
        // Stack<ListNode> stack = new Stack();
        // ListNode cur = head;
        // while (cur != null) {
        //     stack.push(cur);
        //     cur = cur.next;
        // }
        // int count = 0;
        // int size = stack.size();
        // cur = head;
        // while (cur != null) {
        //     ListNode nextnextNode = cur.next;
        //     ListNode nextNode = stack.isEmpty()?null:stack.pop();
        //     if (count >= size/2) {
        //         cur.next = null;
        //         break;
        //     }
        //     count++;
        //     cur.next = nextNode;
        //     nextNode.next = nextnextNode;
        //     cur = nextnextNode;
        // }
        // return;
        
        // Method 2: TC:O(N), SC:O(1)
        if (head == null) {
            return;
        }
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1.next != null && p2.next != null && p2.next.next != null ) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
       
        ListNode cur = p1.next;
        ListNode prev = null;
        while (cur != null) {
            ListNode nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        p1.next = prev;
        
        cur = head;
        ListNode insert = p1.next;
        p1.next = null;
        // System.out.println(insert.val);
        while (insert != null) {
            ListNode nextNode = cur.next;
            ListNode insertnextNode = insert.next;
            cur.next = insert;
            insert.next = nextNode;
            cur = nextNode;
            insert = insertnextNode;
        }
        
        
    }
}