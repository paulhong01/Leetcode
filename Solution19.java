// Leetcode 19: Remove Nth Node From End of List
import java.util.*;

public class Solution19 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        int n = 5;

        Solution19 sol = new Solution19();
        ListNode res = sol.removeNthFromEnd(head, n);
        while (res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
        System.out.println();
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Two pass, TC:O(n), SC:O(1)
        // int count = 0;
        // ListNode cur = head;
        // while (cur != null) {
        //     count++;
        //     cur = cur.next;
        // }

        // ListNode psuedohead = new ListNode(-1);
        // psuedohead.next = head;
        // ListNode prev = psuedohead;
        // cur = head;
        // for (int i = 1; i <= count - n; i++) {
        //     prev = cur;
        //     cur = cur.next;
        // }
        // prev.next = cur.next;

        // return psuedohead.next;

        // One Pass, TC:O(n), SC:O(1)
        ListNode lead = head;
        for (int i = 1; i < n; i++) {
            lead = lead.next;
        }

        ListNode pseudohead = new ListNode(-1);
        pseudohead.next = head;
        ListNode behind = pseudohead;
        while (lead.next != null) {
            lead = lead.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;

        return pseudohead.next;
    }
}