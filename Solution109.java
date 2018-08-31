// Leetcode 109: Convert Sorted List to Binary Search Tree
import java.util.*;

public class Solution109 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        Solution109 sol = new Solution109();
        TreeNode root = sol.sortedListToBST(head);
    }

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null)   return null;

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        System.out.printf("slow: %d\n", slow.val);
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        System.out.printf("prev: %d, slow: %d\n", prev==null?-100:prev.val, slow.val);
        TreeNode root = new TreeNode(slow.val);
        if (prev != null) prev.next = null;
        if (slow != head)   root.left = sortedListToBST(head);
        if (slow.next != null)  root.right = sortedListToBST(slow.next);
        if (prev != null) prev.next = slow;

        return root;
    }
}