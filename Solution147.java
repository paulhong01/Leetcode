// Leetcode 147: Insertion Sort List
import java.util.*;

class Solution147 {
    public ListNode insertionSortList(ListNode head) {
        // TC:O(N), SC:O(1)
        if (head == null)   return null;
        
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        ListNode pre = dummy;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            while (pre.next != null && pre.next.val < cur.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = dummy;
            cur = next;
        }
        return dummy.next;
    }
}