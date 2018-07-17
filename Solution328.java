//Leetcode 328: Odd Even Linked List
import java.util.*;

public class Solution328{
    public static void main(String[] args){
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        Solution328 sol = new Solution328();
        ListNode res = sol.oddEvenList(head);
        while (res != null){
            System.out.printf("%d ", res.val);
            res = res.next;
        }
        System.out.println("");
    }

    public ListNode oddEvenList(ListNode head) {
        // TC:O(n), SC:O(1)
        if (head == null)
            return head;
        ListNode odd = head, even = head.next;
        ListNode evenhead = even;
        while (even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenhead;
        return head;
    }
}