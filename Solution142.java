// Leetcode 142: Linked List Cycle II
import java.util.*;

public class Solution142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = head.next;

        Solution142 sol = new Solution142();
        ListNode res = sol.detectCycle(head);
        System.out.println(res.val);
    }

    public ListNode detectCycle(ListNode head) {
        // TC:O(n), SC:O(1), where n = number of node in linked list
        // Detect cycle
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            // Have cycle
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}