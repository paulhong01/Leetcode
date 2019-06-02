// Leetcode 86: Partition List
import java.util.*;

class Solution86 {
    public ListNode partition(ListNode head, int x) {
        // TC:O(N), SC:O(1)
        ListNode first = new ListNode(-1);
        ListNode second = new ListNode(-1);
        ListNode dummy = first;
        ListNode dummysecond = second;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val < x) {
                first.next = cur;
                cur = cur.next;
                first = first.next;
            } else {
                second.next = cur;
                cur = cur.next;
                second = second.next;
            }
        }
        second.next = null;
        first.next = dummysecond.next;
        return dummy.next;
    }
}