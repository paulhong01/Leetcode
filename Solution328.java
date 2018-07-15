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
        if (head == null)
            return head;
        ListNode oddhead = head, odd = head;
        ListNode evenhead = head.next, even = head.next;
        if (evenhead == null){
            return head;
        }

        ListNode cur = even.next;
        int count = 3;

        while (cur != null){
            if (count % 2 == 1){
                odd.next = cur;
                odd = odd.next;
            } else if (count % 2 == 0){
                even.next = cur;
                even = even.next;
            }
            count++;
            cur = cur.next;
        }
        even.next = null;
        odd.next = evenhead;
        return oddhead;
    }
}