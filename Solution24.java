// Leetcode 24: Swap Nodes in Pairs
import java.util.*;

public class Solution24{
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);

        Solution24 sol = new Solution24();
        ListNode res = sol.swapPairs(head);
        while (res != null) {
            System.out.printf("%d ", res.val);
            res = res.next;
        }
        System.out.println();
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prevfirst = dummy;
        ListNode first = head;
        ListNode second = head.next;
        ListNode secondnext = second.next;
        while (first != null && second != null) {
            // swap
            prevfirst.next = second;
            first.next = secondnext;
            second.next = first;

            prevfirst = first;
            first = secondnext;
            second = (first == null)?null:first.next;
            secondnext = (second == null)?null:second.next;
        }
        return dummy.next;
    }
}