// Leetcode 82: Remove Duplicates from Sorted List II
import java.util.*;

public class Solution82 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);

        Solution82 sol = new Solution82();
        ListNode res = sol.deleteDuplicates(head);
        while (res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)   return null;

        ListNode dump = new ListNode(-1);
        dump.next = head;
        ListNode res = dump;
        ListNode cur = head;

        while (cur != null) {
            while (cur.next != null && cur.next.val == cur.val) cur = cur.next;
            if (dump.next == cur) {
                dump = dump.next;
            } else {
                dump.next = cur.next;
            }
            cur = cur.next;
        }
        return res.next;
        
    }
}