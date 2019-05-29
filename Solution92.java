// Leetcode 92: Reverse Linked List II
import java.util.*;

class Solution92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // TC:O(N), SC:O(1)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = head;
        ListNode reversebegin = dummy;
        ListNode reverseend = null;
        
        int idx = 1;
        while (cur != null && idx != m) {
            reversebegin = cur;
            cur = cur.next;
            idx++;
        }
        ListNode prev = reversebegin;
        ListNode reversehead = cur;
        ListNode curnext = null;
        while (idx != n+1) {
            curnext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = curnext;
            idx++;
        }
        reverseend = curnext;
        reversehead.next = reverseend;
        reversebegin.next = prev;
        
        return dummy.next;
    }
};