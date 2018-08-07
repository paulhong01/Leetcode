// Leetcode 876: Middle of the Linked List
import java.util.*;

public class Solution876 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next = new ListNode(6);

        Solution876 sol = new Solution876();
        ListNode res = sol.middleNode(head);
        System.out.println(res.val);
    }

    public ListNode middleNode(ListNode head) {
        // Method 1: Brute Force, TC:O(n), SC:O(1)
        /* // Find how many elements in this linked list
        int count = 0;
        ListNode cur = head;
        while (cur != null) {
            count++;
            cur = cur.next;
        }

        // Find mid 
        int mid = count/2;

        // Find middle element
        cur = head;
        for (count = 0; count < mid; count++) {
            cur = cur.next;
        }
        return cur; */

        // Method 2 : slow and fast pointer, TC:O(n), SC:O(1)
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}